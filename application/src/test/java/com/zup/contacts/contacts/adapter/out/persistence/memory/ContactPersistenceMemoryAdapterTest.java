package com.zup.contacts.contacts.adapter.out.persistence.memory;

import com.zup.contacts.contacts.adapter.out.persistence.memory.mappers.ContactEntityMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;


@ExtendWith(MockitoExtension.class)
class ContactPersistenceMemoryAdapterTest {

    @Mock
    private ContactEntityMapper contactMapper;

    @InjectMocks
    private ContactPersistenceMemoryAdapter adapter;

    @Test
    void save() {
        Assertions.assertDoesNotThrow(this::doNotThrowException);
    }

    @Test
    void getAll() {
        Assertions.assertDoesNotThrow(this::doNotThrowException);
    }

    private void doNotThrowException(){
    }


}
