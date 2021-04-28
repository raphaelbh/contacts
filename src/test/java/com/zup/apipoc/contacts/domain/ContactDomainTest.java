package com.zup.apipoc.contacts.domain;

import com.zup.apipoc.commons.exceptions.InvalidDomainException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ContactDomainTest {

    @Test
    void validateWithoutErrors() {

        var contact = ContactDomain.builder()
                .name("John Doe")
                .phone("999999999")
                .email("doe@email.com").build();

        contact.validate();
    }



    @Test
    void validateNameRequired() {

        var contact = ContactDomain.builder()
                .name(null)
                .phone("999999999")
                .email("doe@email.com").build();

        assertThrows(InvalidDomainException.class, contact::validate);

    }

    @Test
    void validatePhoneRequired() {

        var contact = ContactDomain.builder()
                .name("John Doe")
                .phone(null)
                .email("doe@email.com").build();

        assertThrows(InvalidDomainException.class, contact::validate);

    }

    @Test
    void validateEmailRequired() {

        var contact = ContactDomain.builder()
                .name("John Doe")
                .phone("999999999")
                .email(null).build();

        assertThrows(InvalidDomainException.class, contact::validate);

    }

    @Test
    void validateLongerName() {

        var contact = ContactDomain.builder()
                .name("John Doe with more than 256 characters ...................................." +
                        "....................................................................................." +
                        "....................................................................................." +
                        "....................................................................................." +
                        "....................................................................................." +
                        ".....................................................................................")
                .phone("999999999")
                .email("doe@email.com").build();

        assertThrows(InvalidDomainException.class, contact::validate);

    }

    @Test
    void sanitizeEmail() {

        var contact = ContactDomain.builder()
                .email("DOE@email.com").build();

        contact.sanitize();

        assertEquals("doe@email.com", contact.getEmail());
    }

    @Test
    void validateEmail() {

        var contact = ContactDomain.builder()
                .name("Roberto Danilo")
                .phone("980469820")
                .email("roberto.email.com")
                .build();

        assertThrows(InvalidDomainException.class, contact::validate);
    }

    @Test
    void validatePhoneOnlyNumber() {

        var contact = ContactDomain.builder()
                .name("Roberto Danilo")
                .phone("99999-9999")
                .email(null).build();

        assertThrows(InvalidDomainException.class, contact::validate);
    }

    @Test
    void validatePhoneSizeNumber() {

        var contact = ContactDomain.builder()
                .name("Roberto Danilo")
                .phone("9999999999")
                .email("roberto@gmail.com")
                .build();

        assertThrows(InvalidDomainException.class, contact::validate);
    }

}
