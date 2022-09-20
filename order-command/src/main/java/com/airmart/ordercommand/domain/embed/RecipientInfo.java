package com.airmart.ordercommand.domain.embed;

import javax.persistence.Embeddable;
import javax.persistence.Embedded;

@Embeddable
public class RecipientInfo {
    private String recipientName;
    @Embedded
    private Address recipientAddress;
    private String recipientPhoneNumber;
}
