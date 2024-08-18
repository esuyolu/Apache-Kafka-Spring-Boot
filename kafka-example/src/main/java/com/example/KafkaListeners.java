package com.example;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaListeners {

    @KafkaListener(topics = "test-topic", groupId = "test-group-id")
    void listener(String data) {
        System.out.println("listener received: " + data + " :)");
    }
}
