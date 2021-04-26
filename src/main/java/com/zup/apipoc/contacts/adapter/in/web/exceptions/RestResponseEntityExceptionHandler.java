package com.zup.apipoc.contacts.adapter.in.web.exceptions;

import com.zup.apipoc.commons.exceptions.RequiredFieldException;
import com.zup.apipoc.contacts.adapter.in.web.exceptions.response.ApiResponseError;
import com.zup.apipoc.contacts.domain.exceptions.InvalidEmailException;
import com.zup.apipoc.contacts.domain.exceptions.InvalidNameException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class RestResponseEntityExceptionHandler  extends ResponseEntityExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiResponseError> handleMethodException(Exception ex) {
        return buildResponseEntity(new ApiResponseError(HttpStatus.INTERNAL_SERVER_ERROR, ex.getMessage()));
    }

    @ExceptionHandler(RequiredFieldException.class)
    public ResponseEntity<ApiResponseError> handleMethodRequiredFieldException(RequiredFieldException ex)  {
        return buildResponseEntity(new ApiResponseError(HttpStatus.BAD_REQUEST, ex.getMessage()));
    }

    @ExceptionHandler(InvalidNameException.class)
    public ResponseEntity<ApiResponseError> handleMethodInvalidNameException(InvalidNameException ex) {
        return buildResponseEntity(new ApiResponseError(HttpStatus.BAD_REQUEST, ex.getMessage()));
    }

    @ExceptionHandler(InvalidEmailException.class)
    public ResponseEntity<ApiResponseError> handleMethodValidateEmailException(InvalidEmailException ex) {
        return buildResponseEntity(new ApiResponseError(HttpStatus.BAD_REQUEST, ex.getMessage()));
    }


    private ResponseEntity<ApiResponseError> buildResponseEntity(ApiResponseError apiResponseError){
        return new ResponseEntity<>(apiResponseError, apiResponseError.getStatus());
    }
}
