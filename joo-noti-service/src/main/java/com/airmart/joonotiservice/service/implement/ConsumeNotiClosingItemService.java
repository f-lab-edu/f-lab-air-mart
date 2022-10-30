package com.airmart.joonotiservice.service.implement;

import com.airmart.joonotiservice.domain.ItemEntryVO;
import com.airmart.joonotiservice.domain.entity.NotificationLog;
import com.airmart.joonotiservice.repository.NotificationLogRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
@RequiredArgsConstructor
public class ConsumeNotiClosingItemService {

    private final NotificationLogRepository notificationLogRepository;

    @KafkaListener(
            topics = "closing_json",
            groupId = "joo_json",
            properties = {"spring.json.value.default.type=com.airmart.joonotiservice.domain.ItemEntryVO"}
    )
    public void listen(ItemEntryVO item) throws IOException{
        System.out.println(item.toString());
        notificationLogRepository.save(NotificationLog.builder()
                .userId("for_test")
                .readAlready(false)
                .notification(item.getItemName() + " was closed, " + item.getCloseTime()).build());
    }
}
