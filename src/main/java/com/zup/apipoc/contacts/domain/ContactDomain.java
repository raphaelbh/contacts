package com.zup.apipoc.contacts.domain;

import com.zup.apipoc.commons.exceptions.RequiredFieldException;

import com.zup.apipoc.contacts.domain.exceptions.InvalidEmailException;
import com.zup.apipoc.contacts.domain.exceptions.InvalidNameException;
import lombok.*;
import org.apache.commons.lang3.StringUtils;

import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Builder
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class ContactDomain {

    @Getter @Setter private Optional<String> id;
    @Getter @Setter private Optional<String> name;
    @Getter @Setter private Optional<String> phone;
    @Getter @Setter private Optional<String> email;

    public void sanitize() {

        if (email.isPresent()) {
            email = Optional.of(email.get().toLowerCase());
        }

    }

    public void validate() {
        validateRequiredFields();
        validateNameField();
        validateEmail();
    }

    private void validateRequiredFields() {

        if (name.isEmpty() || StringUtils.isBlank(name.get())) {
            throw new RequiredFieldException("Name field not informed.");
        }

        if (phone.isEmpty() || StringUtils.isBlank(phone.get())) {
            throw new RequiredFieldException("Phone field not informed.");
        }

        if (email.isEmpty() || StringUtils.isBlank(email.get())) {
            throw new RequiredFieldException("Email field not informed.");
        }

    }

    private void validateNameField() {

        if (name.isEmpty() || name.get().length() > 256) {
            throw new InvalidNameException("The name is longer than 256 characters.");
        }

    }

    private void validateEmail() {
        String regex = "^(.+)@(.+)$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(email.get());
        if(!matcher.matches()) {
            throw new InvalidEmailException("the email is invalid.");
        }
    }

}
