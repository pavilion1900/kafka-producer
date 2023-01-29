package ru.clevertec.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.messaging.Message;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Slf4j
public class MessageProducer {

    private final KafkaTemplate<String, Message> kafkaTemplate;

    @PostMapping("/msg")
    public ResponseEntity<String> generate(@RequestBody String message) {
        Message<String> msg = MessageBuilder
                .withPayload(message)
                .build();
        log.info("Producing Message " + msg.getPayload());
        kafkaTemplate.send("demo-topic3", "someKey", msg);
        return ResponseEntity.ok("Message sent");
    }
}
