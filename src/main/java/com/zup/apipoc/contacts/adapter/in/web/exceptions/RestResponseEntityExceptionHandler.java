package com.zup.apipoc.contacts.adapter.in.web.exceptions;

import com.zup.apipoc.commons.exceptions.InvalidDomainException;
import com.zup.apipoc.contacts.adapter.in.web.exceptions.response.ApiResponseError;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@ControllerAdvice
public class RestResponseEntityExceptionHandler  extends ResponseEntityExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiResponseError> handleMethodException(Exception ex) {
        return buildResponseEntity(new ApiResponseError(HttpStatus.INTERNAL_SERVER_ERROR, ex.getMessage()));
    }

    @ExceptionHandler(InvalidDomainException.class)
    public ResponseEntity<ApiResponseError> handleMethodConstraintViolationException(InvalidDomainException ex) {
        var response = new ApiResponseError();
        response.setStatus(HttpStatus.BAD_REQUEST);
        response.setMessage(response.getMessage());
        response.setFieldErrors(ex.getFieldErrors());
        return buildResponseEntity(response);
    }


    private ResponseEntity<ApiResponseError> buildResponseEntity(ApiResponseError apiResponseError){
        return new ResponseEntity<>(apiResponseError, apiResponseError.getStatus());
    }
}
