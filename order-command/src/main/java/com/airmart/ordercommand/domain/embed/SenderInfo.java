package com.airmart.ordercommand.domain.embed;

import javax.persistence.Embeddable;

@Embeddable
public class SenderInfo {
    private String senderName;
    private String senderPhoneNumber;
}
