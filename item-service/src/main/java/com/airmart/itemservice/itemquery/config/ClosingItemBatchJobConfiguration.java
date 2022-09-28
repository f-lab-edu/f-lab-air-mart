package com.airmart.itemservice.itemquery.config;

import com.airmart.itemservice.itemcommand.dto.ItemCommandDTO;
import com.airmart.itemservice.itemcommand.service.ItemCommandService;
import com.airmart.itemservice.itemquery.domain.ItemEntryVO;
import com.airmart.itemservice.itemquery.service.ItemQueryService;
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

    @Bean
    public Job closingItemBatchJob(){
        return jobBuilderFactory.get("closing-item-batch")
                .start(this.getTopNClosingItems())
                .build();
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
