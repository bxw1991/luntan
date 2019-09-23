package com.shop.exception;

public class BusException extends RuntimeException {
    private Integer code;
    private String message;

    public BusException(Integer code,String message){
        super(message);
        this.code = code;
    }
}
