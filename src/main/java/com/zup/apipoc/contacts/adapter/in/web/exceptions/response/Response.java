package com.zup.apipoc.contacts.adapter.in.web.exceptions.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;


@AllArgsConstructor
public class Response {

    @Getter @Setter private HttpStatus status;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy hh::mm::ss")
    @Getter @Setter private LocalDateTime timestamp;

    @Getter @Setter private String message;

    public Response() {
        this.timestamp = LocalDateTime.now();
    }

    public Response(HttpStatus status, String message) {
        this();
        this.status = status;
        this.message = message;
    }


}
