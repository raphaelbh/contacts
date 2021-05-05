package com.zup.contacts.contacts.adapter.out.producer.kafka;

import com.zup.contacts.contacts.domain.ContactDomain;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;



@Component
@RequiredArgsConstructor
public class ContactProducer {

    @Autowired
    private final KafkaTemplate<String, ContactDomain> template;

    @Value("${tpk.topic-name.contacts}")
    private String topicContactName;

    public void sendContact(ContactDomain contact) {
        template.send(topicContactName, contact);
    }
}
