package com.zup.contacts.contact.adapter.in.consumer.kafka;

import com.zup.contacts.contact.adapter.in.web.request.CreateContactRequest;
import com.zup.contacts.contact.application.port.in.CreateContactCommand;
import com.zup.contacts.contact.application.port.in.CreateContactUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ContactConsumer {

    private final CreateContactUseCase createContactUseCase;

    @KafkaListener(topics = "${kafka.topic.create-contact}", groupId = "${kafka.group.id}", containerFactory = "kafkaListenerContainerFactory")
    public void consumeContactToSave(CreateContactRequest createContactRequest) {

        var command = CreateContactCommand.builder()
                .name(createContactRequest.getName())
                .phone(createContactRequest.getPhone())
                .email(createContactRequest.getEmail())
                .build();

        createContactUseCase.execute(command);
    }
}
