package com.thinkcat.kafkaexampleapplication.example.service;

import com.thinkcat.kafkaexampleapplication.example.domain.ExampleMessage;
import com.thinkcat.kafkaexampleapplication.example.infrastructure.kafka.KafkaMessageProducer;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class ExampleMessageService {

    private final KafkaMessageProducer kafkaMessageProducer;

    public void publishMessage(String payload) {
        ExampleMessage message = new ExampleMessage(payload);
        log.info("[ExampleMessageService] publishMessage payload={}", payload);
        kafkaMessageProducer.send(message.getPayload());
    }

    public void handleConsumedMessage(String rawMessage) {
        ExampleMessage message = new ExampleMessage(rawMessage);
        log.info("[ExampleMessageService] handleConsumedMessage message={}", message);
    }
}
