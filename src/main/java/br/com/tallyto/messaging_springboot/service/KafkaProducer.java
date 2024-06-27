package br.com.tallyto.messaging_springboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaProducer {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    private static final String TOPIC = "my-topic";


    public void sendMessage(String message) {
        kafkaTemplate.send(TOPIC, message);
        System.out.println("Mensagem enviada para o Kafka: " + message);
    }
}
