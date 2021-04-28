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

@ExtendWith(MockitoExtension.class)
class CreateContactUserCaseServiceTest {

    @Mock
    private ContactPersistence contactPersistence;

    @InjectMocks
    private CreateContactUseCaseService service;

    @Test
    void createContact() {

        var expected = ContactDomain.builder()
                .id("123456")
                .name("John Dow")
                .phone("999999999")
                .email("doe@email.com")
                .build();

        Mockito.when(contactPersistence.save(Mockito.any())).thenReturn(expected);

        var command = CreateContactCommand.builder()
                .name("John Dow")
                .phone("999999999")
                .email("DOE@email.com")
                .build();

        var actual = service.execute(command);

        Assertions.assertEquals(expected, actual);
    }

}
