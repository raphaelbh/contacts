package com.zup.apipoc.contacts.adapter.out.persistence.memory.mappers;

import com.zup.apipoc.contacts.adapter.out.persistence.memory.entities.ContactEntity;
import com.zup.apipoc.contacts.domain.ContactDomain;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class ContactEntityMapperTest {

    @InjectMocks
    private ContactEntityMapper mapper;

    @Test
    void convertEntityToDomain() {

        var entity = ContactEntity.builder()
                .id("123456")
                .name("John Doe")
                .phone("999999999")
                .email("doe@email.com")
                .build();

        var actual = mapper.to(entity);
        var expected = ContactDomain.builder()
                .id("123456")
                .name("John Doe")
                .phone("999999999")
                .email("doe@email.com")
                .build();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    void convertDomainToEntity() {

        var domain = ContactDomain.builder()
                .id("123456")
                .name("John Doe")
                .phone("999999999")
                .email("doe@email.com")
                .build();

        var actual = mapper.to(domain);
        var expected = ContactEntity.builder()
                .id("123456")
                .name("John Doe")
                .phone("999999999")
                .email("doe@email.com")
                .build();

        Assertions.assertEquals(expected, actual);
    }

}
