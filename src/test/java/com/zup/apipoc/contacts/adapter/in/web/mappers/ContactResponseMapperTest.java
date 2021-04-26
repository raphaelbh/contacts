package com.zup.apipoc.contacts.adapter.in.web.mappers;

import com.zup.apipoc.contacts.adapter.in.web.response.ContactResponse;
import com.zup.apipoc.contacts.domain.ContactDomain;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.Optional;

@ExtendWith(MockitoExtension.class)
public class ContactResponseMapperTest {

    @InjectMocks
    private ContactResponseMapper mapper;

    @Test
    public void convertDomainEntityToResponse() {

        var domain = ContactDomain.builder()
                .id(Optional.of("123456"))
                .name(Optional.of("John Doe"))
                .phone(Optional.of("9999-9999"))
                .email(Optional.of("doe@email.com"))
                .build();

        var expected = ContactResponse.builder()
                .id("123456")
                .name("John Doe")
                .phone("9999-9999")
                .email("doe@email.com")
                .build();

        var actual = mapper.to(domain);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void convertDomainListToResponse() {

        var domains = Arrays.asList(
                ContactDomain.builder()
                        .id(Optional.of("123"))
                        .name(Optional.of("John Doe"))
                        .phone(Optional.of("9999-9999"))
                        .email(Optional.of("doe@email.com"))
                        .build(),
                ContactDomain.builder()
                        .id(Optional.of("456"))
                        .name(Optional.of("Adam Smith"))
                        .phone(Optional.of("8888-8888"))
                        .email(Optional.of("smith@email.com"))
                        .build()
        );

        var expected = Arrays.asList(
                ContactResponse.builder()
                        .id("123")
                        .name("John Doe")
                        .phone("9999-9999")
                        .email("doe@email.com")
                        .build(),
                ContactResponse.builder()
                        .id("456")
                        .name("Adam Smith")
                        .phone("8888-8888")
                        .email("smith@email.com")
                        .build()
        );

        var actual = mapper.to(domains);
        Assertions.assertEquals(expected, actual);
    }

}
