package br.com.tallyto.messaging_springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/kafka")
public class KafkaProducerController {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    private static final String TOPIC = "my-topic";

    @GetMapping("/send")
    public String sendMessage(@RequestParam("message") String message) {
        kafkaTemplate.send(TOPIC, message);
        return "Message sent to Kafka Topic " + TOPIC;
    }
}
