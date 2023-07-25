
package com.mongo.mechanic.mongo.common.exeptions;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@Log4j2
public class HandlerError extends ResponseEntityExceptionHandler {
    @ExceptionHandler(value = BusinessException.class)
    public ResponseEntity<Error> businessExceptionHandler(BusinessException ex) {
        return ResponseEntity.status(ex.getStatus()).body(new Error(ex.getName(), ex.getMessage(),ex.getIsSuccessful()));
    }

    @ExceptionHandler(value = DomainExeptions.class)
    public ResponseEntity<ErrorDomain> domainExceptionHandler(DomainExeptions ex) {
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(new ErrorDomain(ex.getMessage()));
    }
}
