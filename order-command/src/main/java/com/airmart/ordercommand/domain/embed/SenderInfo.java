package com.airmart.ordercommand.domain.embed;

import javax.persistence.Embeddable;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Embeddable
public class SenderInfo {
    private String senderName;
    private String senderPhoneNumber;

    private SenderInfo(String senderName, String senderPhoneNumber) {
        this.senderName = senderName;
        this.senderPhoneNumber = senderPhoneNumber;
    }

    public static SenderInfo newInstance(String senderName, String senderPhoneNumber) {
        return new SenderInfo(senderName, senderPhoneNumber);
    }


}
