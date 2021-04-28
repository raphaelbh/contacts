package com.zup.apipoc.contacts.adapter.in.web.exceptions.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;
import java.util.List;


@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ApiResponseError {

    @Getter @Setter private HttpStatus status;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy hh::mm::ss")
    @Getter @Setter private LocalDateTime timestamp = LocalDateTime.now();

    @Getter @Setter private String message;

    @Getter @Setter private List<String> apiResponseFieldErrors;


    public ApiResponseError(HttpStatus status, String message) {
        this.status = status;
        this.message = message;
    }


}
