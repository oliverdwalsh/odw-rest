package com.odw.controller;

import com.odw.exception.BasketConditionNotMetException;
import com.odw.service.BasketService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@Slf4j
@RestController
@RequestMapping("api/basket")
public class BasketController {

    @Autowired
    private BasketService basketService;

    @GetMapping(value = "/calculationResponse/{userId}")
    public ResponseEntity<String> getBasketByUserId(@PathVariable("userId") final String userId){

        log.info("Basket By User ID method hit.");
        try {
            String response = basketService.getBasketByUserId(userId);
            return ResponseEntity.ok(response);
        }catch (BasketConditionNotMetException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }

    }
}
