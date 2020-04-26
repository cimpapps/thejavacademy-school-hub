package com.thejavacademy.userservice.config;

import com.thejavacademy.userservice.model.dto.FriendshipRequest;
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
    public ProducerFactory<String, FriendshipRequest> friendshipProducerFactory(KafkaFriendshipConfigs configs) {
        Map<String, Object> producerConfigs = new HashMap<>();
        producerConfigs.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, configs.getBootstrapServers());
        producerConfigs.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, configs.getKeySerializer());
        producerConfigs.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, configs.getValueSerializer());
        return new DefaultKafkaProducerFactory<>(producerConfigs);
    }

    @Bean
    @Autowired
    public KafkaTemplate<String, FriendshipRequest> friendshipKafkaTemplate(ProducerFactory<String, FriendshipRequest> friendshipProducerFactory) {
        return new KafkaTemplate<>(friendshipProducerFactory);
    }


}
