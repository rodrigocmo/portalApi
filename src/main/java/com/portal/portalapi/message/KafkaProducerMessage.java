package com.portal.portalapi.message;

import com.portal.portalapi.db.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class KafkaProducerMessage {

    @Autowired
    private KafkaTemplate<String, Car> kafkaTemplate;

    private final String KAFKA_TOPIC = "car-post-topic";

    public void sendMessage(Car car){
        kafkaTemplate.send(KAFKA_TOPIC, car);
    }

}

