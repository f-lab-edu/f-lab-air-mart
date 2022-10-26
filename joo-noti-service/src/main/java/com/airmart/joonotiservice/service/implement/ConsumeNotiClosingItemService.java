package com.airmart.joonotiservice.service.implement;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class ConsumeNotiClosingItemService {
    @KafkaListener(
            topics = "closing",
            groupId = "joo"
    )
    public void listen(String item) throws IOException{
        System.out.println(item);
    }
}
