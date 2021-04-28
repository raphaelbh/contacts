package com.zup.apipoc.contacts.adapter.in.web.mappers;

import com.zup.apipoc.contacts.adapter.in.web.response.ContactResponse;
import com.zup.apipoc.contacts.domain.ContactDomain;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;

@ExtendWith(MockitoExtension.class)
class ContactResponseMapperTest {

    @InjectMocks
    private ContactResponseMapper mapper;

    @Test
    void convertDomainEntityToResponse() {

        var domain = ContactDomain.builder()
                .id("123456")
                .name("John Doe")
                .phone("999999999")
                .email("doe@email.com")
                .build();

        var expected = ContactResponse.builder()
                .id("123456")
                .name("John Doe")
                .phone("999999999")
                .email("doe@email.com")
                .build();

        var actual = mapper.to(domain);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void convertDomainListToResponse() {

        var domains = Arrays.asList(
                ContactDomain.builder()
                        .id("123")
                        .name("John Doe")
                        .phone("999999999")
                        .email("doe@email.com")
                        .build(),
                ContactDomain.builder()
                        .id("456")
                        .name("Adam Smith")
                        .phone("999999999")
                        .email("smith@email.com")
                        .build()
        );

        var expected = Arrays.asList(
                ContactResponse.builder()
                        .id("123")
                        .name("John Doe")
                        .phone("999999999")
                        .email("doe@email.com")
                        .build(),
                ContactResponse.builder()
                        .id("456")
                        .name("Adam Smith")
                        .phone("999999999")
                        .email("smith@email.com")
                        .build()
        );

        var actual = mapper.to(domains);
        Assertions.assertEquals(expected, actual);
    }

}
