package com.zup.apipoc.contacts.application.service;

import com.zup.apipoc.contacts.application.port.in.CreateContactCommand;
import com.zup.apipoc.contacts.application.port.out.ContactPersistence;
import com.zup.apipoc.contacts.domain.ContactDomain;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

@ExtendWith(MockitoExtension.class)
public class CreateContactUserCaseServiceTest {

    @Mock
    private ContactPersistence contactPersistence;

    @InjectMocks
    private CreateContactUseCaseService service;

    @Test
    public void createContact() {

        var expected = ContactDomain.builder()
                .id(Optional.of("123456"))
                .name(Optional.of("John Dow"))
                .phone(Optional.of("9999-9999"))
                .email(Optional.of("doe@email.com"))
                .build();

        Mockito.when(contactPersistence.save(Mockito.any())).thenReturn(expected);

        var command = CreateContactCommand.builder()
                .name(Optional.of("John Dow"))
                .phone(Optional.of("9999-9999"))
                .email(Optional.of("DOE@email.com"))
                .build();

        var actual = service.execute(command);

        Assertions.assertEquals(expected, actual);
    }

}
