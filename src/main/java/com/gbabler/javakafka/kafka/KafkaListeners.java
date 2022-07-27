package com.gbabler.javakafka.kafka;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import com.gbabler.javakafka.model.User;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class KafkaListeners {

    @KafkaListener(topics = "register")
    public void listener(User user) {
        log.info("User: " + user);
    }

}
