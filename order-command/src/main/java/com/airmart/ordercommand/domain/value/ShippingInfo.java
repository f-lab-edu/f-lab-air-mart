package com.airmart.ordercommand.domain.value;

import lombok.Value;

import javax.persistence.*;

@Value
@Embeddable
public class ShippingInfo {
    /**
     * Data Format => YYYYMMDDHHMMSS-UUID
     */


    public ShippingInfo() {}
}
