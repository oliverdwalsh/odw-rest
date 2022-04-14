package com.odw.service.impl;

import com.odw.exception.BasketConditionNotMetException;
import com.odw.model.Subscription;
import com.odw.service.BasketService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class BasketServiceImpl implements BasketService {


    public BigDecimal calculate(List<Subscription> subscriptions) throws BasketConditionNotMetException {
        return subscriptions.stream().map(Subscription::getPrice).reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    public String getBasketByUserId(String userId){

        String goodResponse = "Customer Retrieved!";

        if(userId.equals("123")){
            return goodResponse;
        }else{
            throw new BasketConditionNotMetException("No Customer", "That Customer Does Not Exist!");
        }

    }


}
