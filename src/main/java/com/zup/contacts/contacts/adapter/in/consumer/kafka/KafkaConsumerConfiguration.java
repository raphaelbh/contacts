package com.zup.contacts.contacts.adapter.in.consumer.kafka;

import com.zup.contacts.contacts.adapter.in.web.request.CreateContactRequest;
import com.zup.contacts.contacts.domain.ContactDomain;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.config.KafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.listener.ConcurrentMessageListenerContainer;
import org.springframework.kafka.support.serializer.JsonDeserializer;

import java.util.HashMap;
import java.util.Map;


@Configuration
public class KafkaConsumerConfiguration {
    @Bean
    public ConsumerFactory<String, CreateContactRequest> consumerFactory(){
        Map<String,Object> config = new HashMap<>();
        config.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG,"localhost:9092");
        config.put(ConsumerConfig.GROUP_ID_CONFIG,"group_contact_id");
        return new DefaultKafkaConsumerFactory<>(config, new StringDeserializer(), new JsonDeserializer<>(CreateContactRequest.class));
    }

    @Bean
    KafkaListenerContainerFactory<ConcurrentMessageListenerContainer<String, CreateContactRequest>> kafkaListenerContainerFactory() {
        ConcurrentKafkaListenerContainerFactory<String, CreateContactRequest> factory = new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(consumerFactory());
        return factory;
    }
}
