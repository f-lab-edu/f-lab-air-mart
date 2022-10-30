package com.airmart.itemservice.itemquery.service.implement;

import com.airmart.itemservice.itemquery.domain.ItemEntryVO;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProduceNotiClosingItemService {
    private static final String TOPIC = "closing_json";
    private final KafkaTemplate<String, ItemEntryVO> kafkaTemplate;

    public void sendClosingItem(ItemEntryVO item){
        System.out.println(item);
        Message message = MessageBuilder.withPayload(item)
                .setHeader(KafkaHeaders.TOPIC, TOPIC)
                .build();
        kafkaTemplate.send(message);
    }
}
