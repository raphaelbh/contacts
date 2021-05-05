package com.zup.contacts.contact.adapter.in.consumer.kafka.configurations;

import com.zup.contacts.contact.adapter.in.web.request.CreateContactRequest;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.config.KafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.listener.ConcurrentMessageListenerContainer;
import org.springframework.kafka.support.serializer.JsonDeserializer;

import java.util.Map;

@Configuration
public class KafkaConsumerConfiguration {

    @Value("${kafka.group.id}")
    private String groupId;

    @Value("${kafka.bootstrap.servers}")
    private String bootstrapServer;

    @Bean
    public ConsumerFactory<String, CreateContactRequest> consumerFactory() {

        final Map<String, Object> config = Map.of(
                ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServer,
                ConsumerConfig.GROUP_ID_CONFIG, groupId
        );

        return new DefaultKafkaConsumerFactory<>(config, new StringDeserializer(), new JsonDeserializer<>(CreateContactRequest.class));
    }

    @Bean
    public KafkaListenerContainerFactory<ConcurrentMessageListenerContainer<String, CreateContactRequest>> kafkaListenerContainerFactory() {

        ConcurrentKafkaListenerContainerFactory<String, CreateContactRequest> factory = new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(consumerFactory());

        return factory;
    }
}
