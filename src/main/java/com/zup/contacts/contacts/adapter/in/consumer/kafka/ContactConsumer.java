package com.zup.contacts.contacts.adapter.in.consumer.kafka;

import com.zup.contacts.contacts.adapter.out.persistence.dynamodb.ContactPersistenceDynamoDBAdapter;
import com.zup.contacts.contacts.domain.ContactDomain;
import io.swagger.v3.oas.models.info.Contact;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ContactConsumer {

    private final ContactPersistenceDynamoDBAdapter contactPersistenceDynamoDBAdapter;

    private static final String TOPIC_CONTACT = "contacts";

    private static final String GROUP_ID = "group_contact_id";

    @KafkaListener(topics = TOPIC_CONTACT, groupId = GROUP_ID, containerFactory = "kafkaListenerContainerFactory")
    public void consumeContactToSave(ContactDomain contactDomain) {
        contactPersistenceDynamoDBAdapter.save(contactDomain);
    }
}
