package com.zup.apipoc.contacts.adapter.out.persistence.memory.mappers;

import com.zup.apipoc.contacts.adapter.out.persistence.memory.entities.ContactEntity;
import com.zup.apipoc.contacts.domain.ContactDomain;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

@ExtendWith(MockitoExtension.class)
public class ContactEntityMapperTest {

    @InjectMocks
    private ContactEntityMapper mapper;

    @Test
    public void convertEntityToDomain() {

        var entity = ContactEntity.builder()
                .id("123456")
                .name("John Doe")
                .phone("9999-9999")
                .email("doe@email.com")
                .build();

        var actual = mapper.to(entity);
        var expected = ContactDomain.builder()
                .id(Optional.of("123456"))
                .name(Optional.of("John Doe"))
                .phone(Optional.of("9999-9999"))
                .email(Optional.of("doe@email.com"))
                .build();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void convertDomainToEntity() {

        var domain = ContactDomain.builder()
                .id(Optional.of("123456"))
                .name(Optional.of("John Doe"))
                .phone(Optional.of("9999-9999"))
                .email(Optional.of("doe@email.com"))
                .build();

        var actual = mapper.to(domain);
        var expected = ContactEntity.builder()
                .id("123456")
                .name("John Doe")
                .phone("9999-9999")
                .email("doe@email.com")
                .build();

        Assertions.assertEquals(expected, actual);
    }

}
