package com.example.consumer;

import com.example.dto.Customer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.TopicPartition;
import org.springframework.stereotype.Service;

@Service
public class KafkaMessageListener {

    Logger logger = LoggerFactory.getLogger(KafkaMessageListener.class);

    @KafkaListener(topics = "java-demo-topic", groupId = "demo", topicPartitions = {@TopicPartition(topic = "java-demo-topic", partitions = {"2"})})
    public void consumeMessage(String message) {
        logger.info("consumer consume the message {} ", message);
    }

    @KafkaListener(topics = "java-json-data-topic", groupId = "demo")
    public void consumeEvent(Customer customer) {
        logger.info("consumer consume the event {} ", customer.toString());
    }
}
