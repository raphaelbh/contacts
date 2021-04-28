package com.zup.apipoc.contacts.adapter.in.web.exceptions.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
public class ApiResponseFieldError {

//   @Getter @Setter private String object;
   @Getter @Setter private String field;
   @Getter @Setter private Object rejectedValue;
   @Getter @Setter private String message;

}
