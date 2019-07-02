package io.github.seata.demo.service.a.controller;

import feign.FeignException;
import io.github.seata.demo.common.exception.BusinessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class RestControllerExceptionHandler {

    @ExceptionHandler(value = BusinessException.class)
    public ResponseEntity<String> handleBusinessException(Throwable exception) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exception.getMessage());
    }

    @ExceptionHandler(value = FeignException.class)
    public ResponseEntity<String> handleFeignException(Throwable exception) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exception.getMessage());
    }


}
