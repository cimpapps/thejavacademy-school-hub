package com.thejavacademy.userservice.service;

import com.thejavacademy.userservice.config.KafkaFriendshipConfigs;
import com.thejavacademy.userservice.model.dto.FriendshipRequest;
import com.thejavacademy.userservice.model.messages.FriendshipEvent;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;


@Slf4j
@Service
public class KafkaFriendshipProducer {

    KafkaFriendshipConfigs friendshipConfigs;

    private KafkaTemplate<String, FriendshipEvent> kafkaTemplate;

    public KafkaFriendshipProducer(KafkaTemplate<String, FriendshipEvent> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendFriendshipEvent(FriendshipEvent friendshipEvent) {
        ProducerRecord<String, FriendshipEvent> record = new ProducerRecord<>(friendshipConfigs.getTopic(),
                friendshipEvent.getTo().toString(),
                friendshipEvent);
        kafkaTemplate.send(record).addCallback(
                sr -> log.info("Friendship Request sent to: ", sr.getProducerRecord()),
                e -> log.error("Kafka didn't receive the friend request", e.getMessage())
        );
    }
}
