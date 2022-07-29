package com.gbabler.javakafka.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gbabler.javakafka.kafka.KafkaSender;
import com.gbabler.javakafka.model.User;

@RestController
@RequestMapping("/kafka")
public class KafkaController {

    private final KafkaSender kafkaSender;

    public KafkaController(final KafkaSender kafkaSender) {
        this.kafkaSender = kafkaSender;
    }

    @PostMapping("/send")
    public void sendMessage(@RequestBody User user) {
        kafkaSender.sendMessageWithCallback("register", user);
    }
}