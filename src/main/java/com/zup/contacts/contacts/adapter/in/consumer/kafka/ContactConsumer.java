package com.zup.contacts.contacts.adapter.in.consumer.kafka;

import com.zup.contacts.contacts.adapter.in.web.request.CreateContactRequest;
import com.zup.contacts.contacts.adapter.out.persistence.dynamodb.ContactPersistenceDynamoDBAdapter;
import com.zup.contacts.contacts.application.port.in.CreateContactCommand;
import com.zup.contacts.contacts.application.port.in.CreateContactUseCase;
import com.zup.contacts.contacts.domain.ContactDomain;
import io.swagger.v3.oas.models.info.Contact;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ContactConsumer {

    private static final String TOPIC_CONTACT = "create-contact";

    private static final String GROUP_ID = "group_contact_id";

    private final CreateContactUseCase createContactUseCase;

    @KafkaListener(topics = TOPIC_CONTACT, groupId = GROUP_ID, containerFactory = "kafkaListenerContainerFactory")
    public void consumeContactToSave(CreateContactRequest createContactRequest) {
        var command = CreateContactCommand.builder()
                .name(createContactRequest.getName())
                .phone(createContactRequest.getPhone())
                .email(createContactRequest.getEmail())
                .build();
        createContactUseCase.execute(command);
    }
}
