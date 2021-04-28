package com.zup.apipoc.contacts.domain;

import com.zup.apipoc.commons.exceptions.InvalidDomainException;
import lombok.*;
import org.apache.commons.collections4.CollectionUtils;

import javax.validation.Validation;
import javax.validation.ValidatorFactory;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;


@Builder
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class ContactDomain {

     @Getter @Setter
     private String id;

     @Getter @Setter
     @NotBlank
     @Size(min = 10, max = 256)
     private String name;

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

    public void validate() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        var errors = factory.getValidator().validate(this);
        List<String> fieldErrors = new ArrayList<>();
        if(CollectionUtils.isNotEmpty(errors)) {
            final String message = "Invalid field error";
            errors.stream().forEach((e) -> fieldErrors.add(e.getPropertyPath() +  ": " +  e.getMessage()));
            throw new InvalidDomainException(message, fieldErrors);
        }
    };


}
