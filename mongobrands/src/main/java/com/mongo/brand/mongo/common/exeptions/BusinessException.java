package com.mongo.brand.mongo.common.exeptions;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
@Setter
public class BusinessException extends RuntimeException{

    private String name;
    private HttpStatus status;
    private Boolean isSuccessful;

    public BusinessException(String message, String name, HttpStatus status, Boolean isSuccessful) {
        super(message);
        this.name = name;
        this.status = status;
        this.isSuccessful = isSuccessful;
    }
}