package com.zup.contacts.contact.adapter.in.web.mappers;

import com.zup.contacts.contact.adapter.in.web.response.ContactResponse;
import com.zup.contacts.contact.domain.ContactDomain;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;

import java.util.Arrays;

@ExtendWith(MockitoExtension.class)
class ContactResponseMapperTest {

    @Spy
    private ModelMapper modelMapper;

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

        var actual = mapper.domainToResponse(domain);
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

        var actual = mapper.domainToResponse(domains);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void convertDomainEntityToResponseWithoutId() {

        var domain = ContactDomain.builder()
                .name("John Doe")
                .phone("999999999")
                .email("doe@email.com")
                .build();

        var expected = ContactResponse.builder()
                .name("John Doe")
                .phone("999999999")
                .email("doe@email.com")
                .build();

        var actual = mapper.domainToResponse(domain);
        Assertions.assertEquals(expected, actual);
    }

}
