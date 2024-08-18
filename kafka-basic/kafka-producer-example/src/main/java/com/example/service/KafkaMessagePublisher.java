package com.example.service;

import com.example.dto.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Service
public class KafkaMessagePublisher {

    @Autowired
    private KafkaTemplate<String, Object> template;

    public void sendMessageToTopic(String message) {
        CompletableFuture<SendResult<String, Object>> future = template.send("java-demo-topic", 3, null, message);
        future.whenComplete((result, exception) -> {
            if (exception == null) {
                System.out.println("Sent message=[" + message + "] with offset=[" + result.getRecordMetadata().offset() + "]");
            } else {
                System.out.println("Unable to send message=[" + message + "] due to: " + exception.getMessage());
            }
        });
    }

    public void sendEventToTopic(Customer customer) {
        try {
            CompletableFuture<SendResult<String, Object>> future = template.send("java-json-data-topic", customer);
            future.whenComplete((result, exception) -> {
                if (exception == null) {
                    System.out.println("Sent event=[" + customer.toString() + "] with offset=[" + result.getRecordMetadata().offset() + "]");
                } else {
                    System.out.println("Unable to send event=[" + customer.toString() + "] due to: " + exception.getMessage());
                }
            });
        } catch (Exception ex) {
            System.out.println("error: " + ex.getMessage());
        }
    }
}
