package com.zup.contacts.contacts.domain;

import com.zup.contacts.commons.exceptions.InvalidDomainException;
import lombok.*;
import org.apache.commons.collections4.CollectionUtils;

import javax.validation.Validation;
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
     @Size(min = 4, max = 256)
     private String name;

     @Getter @Setter
     @NotBlank
     @Size(min=13, max = 13)
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
        var factory = Validation.buildDefaultValidatorFactory();
        var errors = factory.getValidator().validate(this);
        List<String> fieldErrors = new ArrayList<>();
        if(CollectionUtils.isNotEmpty(errors)) {
            final var message = "Invalid field error";
            errors.forEach(e -> fieldErrors.add(e.getPropertyPath() +  ": " +  e.getMessage()));
            throw new InvalidDomainException(message, fieldErrors);
        }
    }


}
