package com.kafkaexample.springboot.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaTopicConfig {

    @Bean
    public NewTopic myFirstTopic() {
        return TopicBuilder.name("myFirst").build();
    }

    @Bean
    public NewTopic mySecondTopic() {
        return TopicBuilder.name("mySecondTopic_json").build();
    }
}
