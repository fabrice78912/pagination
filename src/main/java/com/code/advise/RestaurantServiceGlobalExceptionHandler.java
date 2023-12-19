package com.code.advise;


import com.code.dto.CustomErrorResponse;
import com.code.dto.GlobalErrorCode;
import com.code.exception.InternalServerErrorException;
import com.code.exception.UserNotFoundException;
import lombok.extern.slf4j.Slf4j;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Slf4j
public class RestaurantServiceGlobalExceptionHandler {

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<?> handleOrderNotFoundException(UserNotFoundException ex){
        CustomErrorResponse errorResponse= CustomErrorResponse.builder()
                .status(HttpStatus.NOT_FOUND)
                .errorMessage(ex.getMessage())
                .build()  ;
        log.error("RestaurantServiceGlobalExceptionHandler::handleOrderNotFoundException exception caught {}",ex.getMessage());
        return ResponseEntity.ok(errorResponse);
    }

    @ExceptionHandler(InternalServerErrorException.class)
    public ResponseEntity<?> handleGenericException(Exception ex){
        CustomErrorResponse errorResponse= CustomErrorResponse.builder()
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .errorCode(GlobalErrorCode.GENERIC_ERROR)
                .errorMessage(ex.getMessage())
                .build()  ;
        log.error("RestaurantServiceGlobalExceptionHandler::handleGenericException exception caught {}",ex.getMessage());
        return ResponseEntity.internalServerError().body(errorResponse);
    }
}
