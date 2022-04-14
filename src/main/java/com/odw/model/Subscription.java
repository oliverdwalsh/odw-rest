package com.odw.model;

import com.odw.model.enums.SubscriptionType;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class Subscription {

    private String id;

    private SubscriptionType subType;

    private BigDecimal price;

    public Subscription(String id, SubscriptionType subType, BigDecimal price){
        this.id = id;
        this.subType = subType;
        this.price = price;
    }
}
