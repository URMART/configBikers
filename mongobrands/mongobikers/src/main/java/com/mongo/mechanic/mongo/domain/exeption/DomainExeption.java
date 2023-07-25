package com.mongo.mechanic.mongo.domain.exeption;

public class DomainExeption extends RuntimeException {
    public DomainExeption(String message) {
        super(message);
    }
}