package com.odw.exception;

public class BasketConditionNotMetException extends RuntimeException {

    private String reason;

    public BasketConditionNotMetException(String message, String reason){
        super(message);
        this.reason = reason;
    }
}
