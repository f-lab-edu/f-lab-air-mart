package com.airmart.joonotiservice.contorller;

import com.airmart.joonotiservice.common.dto.CommonResponse;
import com.airmart.joonotiservice.dto.NotificationDTO;
import com.airmart.joonotiservice.service.JooNotiService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/joo/noti")
@RequiredArgsConstructor
public class NotiController {
    final private JooNotiService jooNotiService;

    @GetMapping
    public String notiHello(){
        return "hello noti";
    }

    @GetMapping("/{userId}")
    public ResponseEntity<CommonResponse<List<NotificationDTO.Response>>> getNotiByUserId(@PathVariable String userId){
        return ResponseEntity.ok().body(CommonResponse.success(jooNotiService.getNotificationList(userId)));
    }
}
