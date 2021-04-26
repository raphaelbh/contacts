package com.zup.apipoc.contacts.adapter.in.web.exceptions.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;



public class ApiResponseError {

    @Getter @Setter private HttpStatus status;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy hh::mm::ss")
    @Getter @Setter private LocalDateTime timestamp = LocalDateTime.now();

    @Getter @Setter private String message;


    public ApiResponseError(HttpStatus status, String message) {
        this.status = status;
        this.message = message;
    }


}
