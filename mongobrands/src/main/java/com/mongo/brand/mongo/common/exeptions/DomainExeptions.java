package com.mongo.brand.mongo.common.exeptions;

public class DomainExeptions extends  RuntimeException{
    public DomainExeptions(String message) {
        super(message);
    }
}
