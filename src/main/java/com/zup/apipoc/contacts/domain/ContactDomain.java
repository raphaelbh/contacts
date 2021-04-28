package com.zup.apipoc.contacts.domain;

import com.zup.apipoc.commons.exceptions.InvalidFieldException;
import lombok.*;

import javax.validation.Valid;
import javax.validation.Validation;
import javax.validation.ValidatorFactory;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;


@Builder
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class ContactDomain {

     @Getter @Setter
     private String id;

     @Getter @Setter
     @NotBlank
     @Size(max = 256)
     private  String name;

     @Getter @Setter
     @NotBlank
     @Size(min=9, max = 9)
     @Pattern(regexp="^(0|[1-9][0-9]*)$",message = "phone should have only numbers")
     private String phone;

     @Getter @Setter
     @NotBlank @Email
     private String email;

    public void sanitize() {

        if (email != null) {
            email = email.toLowerCase();
        }

    }

    @Valid
    public static ContactDomain create ( @NotBlank @Size(max = 256) String name ) {
        return null;
    };


    public void validate() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        var errors = factory.getValidator().validate(this);
        if(!errors.isEmpty()) {
            final StringBuilder builder = new StringBuilder("Field(s) Error(s): ");
            errors.stream().forEach((e) -> builder.append(e.getPropertyPath() +  ": " +  e.getMessage() + " \n "));
            throw new InvalidFieldException(builder.toString());
        }
    };


}
