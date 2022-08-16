package com.example.ibm.exception;

import org.springframework.http.HttpStatus;

public class BusinessException extends RuntimeException{

    public BusinessException(String message){

        super(message);
    }

}
