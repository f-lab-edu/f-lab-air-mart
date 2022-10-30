package com.airmart.itemservice.itemquery.config;

import com.airmart.itemservice.common.exception.BusinessException;
import com.airmart.itemservice.itemcommand.dto.ItemCommandDTO;
import com.airmart.itemservice.itemcommand.service.ItemCommandService;
import com.airmart.itemservice.itemquery.domain.ItemEntryVO;
import com.airmart.itemservice.itemquery.dto.ItemQueryDTO;
import com.airmart.itemservice.itemquery.service.ItemQueryService;
import com.airmart.itemservice.itemquery.service.implement.ProduceNotiClosingItemService;
import com.airmart.itemservice.itemquery.service.util.ItemQueryMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.Instant;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Configuration
@RequiredArgsConstructor
public class ClosingItemBatchJobConfiguration {
    private final JobBuilderFactory jobBuilderFactory;
    private final StepBuilderFactory stepBuilderFactory;
    private final ItemCommandService itemCommandService;
    private final ItemQueryService itemQueryService;
    private final ProduceNotiClosingItemService produceNotiClosingItemService;

    @Bean
    public Job closingItemBatchJob(){
        return jobBuilderFactory.get("closing-item-batch")
                .start(this.notiClosedItems())
                .next(this.getTopNClosingItems())
                .build();
    }

    @Bean
    public Step notiClosedItems(){
        return stepBuilderFactory.get("noti-closed-items")
                .tasklet((contribution, chunkContext) -> {
                    log.info("Noti closed Item list");
                    ItemQueryDTO.Response itemList;
                    try {
                        itemList = itemQueryService.getClosingItemList();
                    } catch (BusinessException ignored){}
//                        for(ItemEntryVO item : itemList.getItemList()){
//                            produceNotiClosingItemService.sendClosingItem(item.toString());
//                        }
                    // for test
                    for(long i = 0 ; i < 10 ; i++){
                        ItemEntryVO temp = ItemEntryVO.builder().itemName("test"+i)
                                .id(i)
                                .closeTime(Instant.now().toString())
                                .build();
                        produceNotiClosingItemService.sendClosingItem(temp);
                    }
                    return RepeatStatus.FINISHED;
                }).build();
    }

    @Bean
    public Step getTopNClosingItems(){
        return stepBuilderFactory.get("get-topN-closing-items")
                .tasklet((contribution, chunkContext) -> {
                    log.info("Start to collect closing Item list");
                    List<ItemCommandDTO.Response> itemList = itemCommandService.getClosingItemList();
                    itemQueryService.cachingClosingItems(itemList);

                    return RepeatStatus.FINISHED;
                }).build();
    }
}
