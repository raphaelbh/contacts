package com.zup.apipoc.contacts.application.service;

import com.zup.apipoc.contacts.application.port.out.ContactPersistence;
import com.zup.apipoc.contacts.domain.ContactDomain;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.Optional;

@ExtendWith(MockitoExtension.class)
public class ListContactUserCaseServiceTest {

    @Mock
    private ContactPersistence contactPersistence;

    @InjectMocks
    private ListContactUseCaseService service;

    @Test
    public void listContacts() {

        var expected = Arrays.asList(
                ContactDomain.builder().id("123").build(),
                ContactDomain.builder().id("456").build()
        );

        Mockito.when(contactPersistence.getAll()).thenReturn(expected);

        var actual = service.execute();
        Assertions.assertEquals(expected, actual);
    }

}
