package com.thejavacademy.userservice.service;

import com.thejavacademy.userservice.config.KafkaUserConfigs;
import com.thejavacademy.userservice.model.messages.FriendshipEvent;
import com.thejavacademy.userservice.model.messages.UserEvent;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class KafkaUserProducer {

    KafkaUserConfigs kafkaUserConfigs;

    private KafkaTemplate<String, UserEvent> kafkaTemplate;

    public KafkaUserProducer(KafkaUserConfigs kafkaUserConfigs, KafkaTemplate<String, UserEvent> kafkaTemplate) {
        this.kafkaUserConfigs = kafkaUserConfigs;
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendUserEvent(UserEvent userEvent) {
        ProducerRecord<String, UserEvent> record = new ProducerRecord<>(kafkaUserConfigs.getTopic(),
                userEvent.getEmail().toString(),
                userEvent);
        kafkaTemplate.send(record).addCallback(
                sr -> {
                    if(sr != null)
                        log.info("User details sent: " + sr.getProducerRecord());
                    else log.info("record is null");
                },
                e -> log.error("Kafka didn't receive th message: " + e.getMessage())
        );
    }
}
