package com.mongo.mechanic.mongo.common.exeptions;

import org.springframework.http.HttpStatus;

public class DomainExeptions extends  RuntimeException{

    public DomainExeptions(String message) {
        super(message);
    }
}
