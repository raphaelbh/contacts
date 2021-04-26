package com.zup.apipoc.contacts.domain;

import com.zup.apipoc.commons.exceptions.RequiredFieldException;
import com.zup.apipoc.contacts.domain.exceptions.InvalidNameException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Optional;

public class ContactDomainTest {

    @Test
    public void validateWithoutErrors() {

        var contact = ContactDomain.builder()
                .name(Optional.of("John Doe"))
                .phone(Optional.of("9999-9999"))
                .email(Optional.of("doe@email.com")).build();

        contact.validate();
    }

    @Test
    public void validateNameRequired() {

        assertThrows(RequiredFieldException.class, () -> {

            var contact = ContactDomain.builder()
                    .name(Optional.empty())
                    .phone(Optional.of("9999-9999"))
                    .email(Optional.of("doe@email.com")).build();

            contact.validate();

        });

    }

    @Test
    public void validatePhoneRequired() {

        assertThrows(RequiredFieldException.class, () -> {

            var contact = ContactDomain.builder()
                    .name(Optional.of("John Doe"))
                    .phone(Optional.empty())
                    .email(Optional.of("doe@email.com")).build();

            contact.validate();

        });

    }

    @Test
    public void validateEmailRequired() {

        assertThrows(RequiredFieldException.class, () -> {

            var contact = ContactDomain.builder()
                    .name(Optional.of("John Doe"))
                    .phone(Optional.of("9999-9999"))
                    .email(Optional.empty()).build();

            contact.validate();

        });

    }

    @Test
    public void validateLongerName() {

        assertThrows(InvalidNameException.class, () -> {

            var contact = ContactDomain.builder()
                    .name(Optional.of("John Doe with more than 256 characters ...................................." +
                            "....................................................................................." +
                            "....................................................................................." +
                            "....................................................................................." +
                            "....................................................................................." +
                            "....................................................................................."))
                    .phone(Optional.of("9999-9999"))
                    .email(Optional.of("doe@email.com")).build();

            contact.validate();

        });

    }

    @Test
    public void sanitizeEmail() {

        var contact = ContactDomain.builder()
                .email(Optional.of("DOE@email.com")).build();

        contact.sanitize();

        assertEquals("doe@email.com", contact.getEmail().get());
    }

}
