package com.odw.service;

import com.odw.model.Subscription;

import java.math.BigDecimal;
import java.util.List;

public interface BasketService {

    BigDecimal calculate(List<Subscription> subscriptions);

    String getBasketByUserId(String userId);
}
