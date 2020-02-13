package io.pivotal.kafkademo;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import lombok.extern.apachecommons.CommonsLog;

@Service
@CommonsLog(topic = "Producer Logger")
@RequiredArgsConstructor
public class Producer {

    @Value("${topic.name}")
    private String TOPIC;

    private final KafkaTemplate<String, User> kafkaTemplate;

    void sendMessage(User user) {
        this.kafkaTemplate.send(this.TOPIC, user.getName(), user);
        log.info(String.format("Produced user -> %s", user));
    }
}