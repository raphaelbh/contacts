package com.zup.apipoc.contacts.domain;

import com.zup.apipoc.commons.exceptions.InvalidFieldException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Optional;

public class ContactDomainTest {

    @Test
    public void validateWithoutErrors() {

        var contact = ContactDomain.builder()
                .name("John Doe")
                .phone("999999999")
                .email("doe@email.com").build();

        contact.validate();
    }



    @Test
    public void validateNameRequired() {

        assertThrows(InvalidFieldException.class, () -> {

            var contact = ContactDomain.builder()
                    .name(null)
                    .phone("999999999")
                    .email("doe@email.com").build();

            contact.validate();

        });

    }

    @Test
    public void validatePhoneRequired() {

        assertThrows(InvalidFieldException.class, () -> {

            var contact = ContactDomain.builder()
                    .name("John Doe")
                    .phone(null)
                    .email("doe@email.com").build();

            contact.validate();

        });

    }

    @Test
    public void validateEmailRequired() {

        assertThrows(InvalidFieldException.class, () -> {

            var contact = ContactDomain.builder()
                    .name("John Doe")
                    .phone("999999999")
                    .email(null).build();

            contact.validate();

        });

    }

    @Test
    public void validateLongerName() {

        assertThrows(InvalidFieldException.class, () -> {

            var contact = ContactDomain.builder()
                    .name("John Doe with more than 256 characters ...................................." +
                            "....................................................................................." +
                            "....................................................................................." +
                            "....................................................................................." +
                            "....................................................................................." +
                            ".....................................................................................")
                    .phone("999999999")
                    .email("doe@email.com").build();

            contact.validate();

        });

    }

    @Test
    public void sanitizeEmail() {

        var contact = ContactDomain.builder()
                .email("DOE@email.com").build();

        contact.sanitize();

        assertEquals("doe@email.com", contact.getEmail());
    }

    @Test
    public void validateEmail() {
        assertThrows(InvalidFieldException.class, () -> {
            var contact = ContactDomain.builder()
                    .name("Roberto Danilo")
                    .phone("980469820")
                    .email("roberto.email.com")
                    .build();

            contact.validate();
        });
    }

    @Test
    public void validatePhoneOnlyNumber() {
        assertThrows(InvalidFieldException.class, () -> {
            var contact = ContactDomain.builder()
                    .name("Roberto Danilo")
                    .phone("99999-9999")
                    .email(null).build();

            contact.validate();
        });
    }

    @Test
    public void validatePhoneSizeNumber() {
        assertThrows(InvalidFieldException.class, () -> {
            var contact = ContactDomain.builder()
                    .name("Roberto Danilo")
                    .phone("9999999999")
                    .email("roberto@gmail.com")
                    .build();

            contact.validate();
        });
    }

}
