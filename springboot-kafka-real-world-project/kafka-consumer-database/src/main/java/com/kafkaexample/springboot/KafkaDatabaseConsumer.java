package com.kafkaexample.springboot;

import com.kafkaexample.springboot.entity.WikipediaData;
import com.kafkaexample.springboot.repository.WikipediaDataRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaDatabaseConsumer {

    private static final Logger LOGGER = LoggerFactory.getLogger(KafkaDatabaseConsumer.class);

    private final WikipediaDataRepository wikipediaDataRepository;

    public KafkaDatabaseConsumer(WikipediaDataRepository wikipediaDataRepository) {
        this.wikipediaDataRepository = wikipediaDataRepository;
    }

    @KafkaListener(topics = "wikipedia_recent_change", groupId = "myGroup")
    public void consume(String eventMessage) {
        LOGGER.info(String.format("Event Message received -> %s", eventMessage));
        WikipediaData wikipediaData = new WikipediaData();
        wikipediaData.setWikiEventData(eventMessage);
        wikipediaDataRepository.save(wikipediaData);
    }
}
