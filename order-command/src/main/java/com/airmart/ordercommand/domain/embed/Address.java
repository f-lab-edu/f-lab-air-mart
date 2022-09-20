package com.airmart.ordercommand.domain.embed;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;

@Getter
@Embeddable @NoArgsConstructor
public class Address {
    private String firstAddress;
    private String secondAddress;
    private String zipCode;

    @Builder
    public Address(String firstAddress, String secondAddress, String zipCode) {
        this.firstAddress = firstAddress;
        this.secondAddress = secondAddress;
        this.zipCode = zipCode;
    }
}
