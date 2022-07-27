package com.gbabler.javakafka.kafka;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Component;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

import com.gbabler.javakafka.model.User;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class KafkaSender {

    private final KafkaTemplate<String, User> kafkaTemplate;

    public KafkaSender(final KafkaTemplate<String, User> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendMessage(String topicName, User user) {
        kafkaTemplate.send(topicName, user);
    }

    public void sendMessageWithCallback(String topicName, User user) {
        ListenableFuture<SendResult<String, User>> future = kafkaTemplate.send(topicName, user);

        future.addCallback(new ListenableFutureCallback<SendResult<String, User>>() {
            @Override public void onFailure(final Throwable ex) {
                log.error("Unable to delivery message {}", user, ex);
            }

            @Override public void onSuccess(final SendResult<String, User> result) {
                log.info("Message {} sent successfully with offset {}", user, result.getRecordMetadata().offset());
            }
        });
    }
}
