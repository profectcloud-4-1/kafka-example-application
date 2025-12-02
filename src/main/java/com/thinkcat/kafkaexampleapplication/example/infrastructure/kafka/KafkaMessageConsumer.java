package com.thinkcat.kafkaexampleapplication.example.infrastructure.kafka;

import com.thinkcat.kafkaexampleapplication.example.service.ExampleMessageService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class KafkaMessageConsumer {

    private final ExampleMessageService messageService;

    @KafkaListener(topics = "${app.kafka.topic}", groupId = "demo-group")
    public void listen(String message) {
        log.info("[KafkaMessageConsumer] received raw message: {}", message);
        messageService.handleConsumedMessage(message);
    }
}