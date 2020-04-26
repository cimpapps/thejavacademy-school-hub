package com.thejavacademy.userservice.service;

import com.thejavacademy.userservice.config.KafkaFriendshipConfigs;
import com.thejavacademy.userservice.model.dto.FriendshipRequest;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;


@Slf4j
@Service
public class KafkaFriendshipService {

    KafkaFriendshipConfigs friendshipConfigs;

    private KafkaTemplate<String, FriendshipRequest> kafkaTemplate;

    public KafkaFriendshipService(KafkaTemplate<String, FriendshipRequest> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendFriendRequest(FriendshipRequest friendshipRequest) {

        ProducerRecord<String, FriendshipRequest> record = new ProducerRecord<>(friendshipConfigs.getTopic(),
                friendshipRequest.sentTo(), friendshipRequest);
        kafkaTemplate.send(record).addCallback(
                sr -> log.info("Friendship Request sent to: ", sr.getProducerRecord()),
                e -> log.error("Kafka didn't receive the friend request", e.getMessage())
        );
    }
}
