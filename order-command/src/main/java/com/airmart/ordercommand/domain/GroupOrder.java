package com.airmart.ordercommand.domain;

import java.time.LocalDateTime;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class GroupOrder extends BaseAuditor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Data Format => YYYYMMDDHHMMSS-UUID
     */
    private String groupOrderId;

    @OneToMany(mappedBy = "groupOrder", cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE}, orphanRemoval = true)
    private List<Order> orders = new ArrayList<>();

    private Integer minimumQuantity;

    private LocalDateTime startDate;

    private LocalDateTime endDate;
}
