package io.pivotal.kafkademo;

import lombok.extern.apachecommons.CommonsLog;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@CommonsLog(topic = "Consumer Logger")
public class Consumer {

    @KafkaListener(
            topics = "#{'${topic.name}'}",
            groupId = "simple-consumer"
    )
    public void consume(User record) {
        log.info(String.format("Consumed message -> %s", record));
    }
}
