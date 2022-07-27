package com.gbabler.javakafka.kafka.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaTopicConfig {

    @Bean
    public NewTopic topicRegister() {
        return TopicBuilder.name("register").build();
    }

    @Bean
    public NewTopic topicSell() {
        return TopicBuilder.name("sell").build();
    }

    @Bean
    public NewTopic topicReverse() {
        return TopicBuilder.name("reverse").build();
    }
}