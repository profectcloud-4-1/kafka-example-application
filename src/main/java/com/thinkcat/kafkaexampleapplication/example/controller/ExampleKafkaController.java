package com.thinkcat.kafkaexampleapplication.example.controller;

import com.thinkcat.kafkaexampleapplication.example.service.ExampleMessageService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/example/kafka")
@RequiredArgsConstructor
public class ExampleKafkaController {

    private final ExampleMessageService messageService;

    @PostMapping("/send")
    public ResponseEntity<String> sendMessage(@RequestParam("message") String message) {
        messageService.publishMessage(message);
        return ResponseEntity.ok("sent: " + message);
    }
}
