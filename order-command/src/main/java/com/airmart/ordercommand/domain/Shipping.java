package com.airmart.ordercommand.domain;

import com.airmart.ordercommand.domain.embed.Address;

import javax.persistence.*;

@Entity
public class Shipping extends BaseAuditor{
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String shippingCode;
    @Embedded
    private Address address;
    private String shippingRequests;
}
