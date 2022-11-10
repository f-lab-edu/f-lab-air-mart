package com.airmart.ordercommand.domain.embed;

import javax.persistence.Embeddable;
import javax.persistence.Embedded;

@Embeddable
public class RecipientInfo {
    private String recipientName;
    @Embedded
    private Address recipientAddress;
    private String recipientPhoneNumber;

    public RecipientInfo() {}

    private RecipientInfo(String recipientName, String recipientPhoneNumber,
        Address recipientAddress) {
        this.recipientName = recipientName;
        this.recipientAddress = recipientAddress;
        this.recipientPhoneNumber = recipientPhoneNumber;
    }

    public static RecipientInfo newInstance(String recipientName, String recipientPhoneNumber,
        String firstAddress, String secondAddress, String zipcode) {
        return new RecipientInfo(recipientName, recipientPhoneNumber,
            Address.newInstance(firstAddress, secondAddress, zipcode));
    }
}
