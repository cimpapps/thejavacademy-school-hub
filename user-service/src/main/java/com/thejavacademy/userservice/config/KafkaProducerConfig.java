package com.thejavacademy.userservice.config;

import com.thejavacademy.userservice.model.dto.FriendshipRequest;
import com.thejavacademy.userservice.model.entity.User;
import com.thejavacademy.userservice.model.messages.FriendshipEvent;
import com.thejavacademy.userservice.model.messages.UserEvent;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class KafkaProducerConfig {

    @Bean
    @Autowired
    public ProducerFactory<String, FriendshipEvent> friendshipProducerFactory(KafkaFriendshipConfigs configs) {
        Map<String, Object> producerConfigs = new HashMap<>();
        producerConfigs.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, configs.getBootstrapServers());
        producerConfigs.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, configs.getKeySerializer());
        producerConfigs.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, configs.getValueSerializer());
        producerConfigs.put("schema.registry.url", configs.getSchemaRegistryUrl());
        return new DefaultKafkaProducerFactory<>(producerConfigs);
    }

    @Bean
    @Autowired
    public KafkaTemplate<String, FriendshipEvent> friendshipKafkaTemplate(ProducerFactory<String, FriendshipEvent> friendshipProducerFactory) {
        return new KafkaTemplate<>(friendshipProducerFactory);
    }

    @Autowired
    @Bean
    public ProducerFactory<String, UserEvent> userProducerFactory(KafkaUserConfigs userConfigs) {
        Map<String, Object> producerConfigs = new HashMap<>();
        producerConfigs.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, userConfigs.getBootstrapServers());
        producerConfigs.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, userConfigs.getKeySerializer());
        producerConfigs.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, userConfigs.getValueSerializer());
        producerConfigs.put("schema.registry.url", userConfigs.getSchemaRegistryUrl());
        return new DefaultKafkaProducerFactory<>(producerConfigs);

    }

    @Autowired
    @Bean
    public KafkaTemplate<String, UserEvent> userEventKafkaTemplate(ProducerFactory<String, UserEvent> userProducerFactory){
        return new KafkaTemplate<>(userProducerFactory);
    }


}
