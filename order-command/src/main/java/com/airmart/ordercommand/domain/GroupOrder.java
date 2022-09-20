package com.airmart.ordercommand.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class GroupOrder extends BaseAuditor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy = "groupOrder")
    private List<Order> orders = new ArrayList<>();

    private Integer minimumQuantity;

}
