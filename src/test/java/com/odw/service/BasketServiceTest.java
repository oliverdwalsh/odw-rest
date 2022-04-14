package com.odw.service;

import com.odw.exception.BasketConditionNotMetException;
import com.odw.model.Subscription;
import com.odw.model.enums.SubscriptionType;
import com.odw.service.impl.BasketServiceImpl;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class BasketServiceTest {

    @InjectMocks
    private BasketServiceImpl basketService;

    @Test
    public void calculate_correctlyAdds_allSubscriptions(){

        BigDecimal result = basketService.calculate(createTestSubs());

        Assert.assertEquals(0, result.compareTo(BigDecimal.valueOf(45.00)));

    }

    @Test
    public void getBasketByUserId_returnsBasket_withValidId(){

        String response = basketService.getBasketByUserId("123");

        Assert.assertEquals("Customer Retrieved!", response);

    }

    @Test(expected = BasketConditionNotMetException.class)
    public void getBasketByUserId_throwsError_withInvalidId(){

        String response = basketService.getBasketByUserId("456");

        Mockito.verify(basketService).getBasketByUserId("456");

    }


    private List<Subscription> createTestSubs(){

        Subscription sub1 = new Subscription("Sub1", SubscriptionType.SUB_1, BigDecimal.valueOf(20));
        Subscription sub2 = new Subscription("Sub2", SubscriptionType.SUB_2, BigDecimal.valueOf(10));
        Subscription sub3 = new Subscription("Sub3", SubscriptionType.SUB_3, BigDecimal.valueOf(15));

        return new ArrayList<>(Arrays.asList(sub1, sub2, sub3));
    }


}