package com.zup.apipoc.contacts.adapter.in.web.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
public class CreateContactRequest implements Serializable {
    @Schema(name = "name", type = "String", example = "John Conor")
    @Getter @Setter private String name;
    @Schema(name = "phone", type = "String", example = "5591980563029")
    @Getter @Setter private String phone;
    @Schema(name = "email", type = "String", example = "jconor@gmail.com")
    @Getter @Setter private String email;

}
