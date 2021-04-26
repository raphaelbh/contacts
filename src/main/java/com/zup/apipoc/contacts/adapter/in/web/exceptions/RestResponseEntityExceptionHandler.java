package com.zup.apipoc.contacts.adapter.in.web.exceptions;

import com.zup.apipoc.commons.exceptions.RequiredFieldException;
import com.zup.apipoc.contacts.adapter.in.web.exceptions.response.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class RestResponseEntityExceptionHandler  extends ResponseEntityExceptionHandler {

    @ExceptionHandler(RequiredFieldException.class)
    public ResponseEntity<Object> handleMethodRequiredFieldException(RequiredFieldException ex)  {
        return buildResponseEntity(new Response(HttpStatus.BAD_REQUEST, ex.getMessage()));
    }

    private ResponseEntity<Object> buildResponseEntity(Response response){
        return new ResponseEntity<>(response, response.getStatus());
    }
}
