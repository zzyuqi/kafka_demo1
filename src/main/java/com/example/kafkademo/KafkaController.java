package com.example.kafkademo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/kafka")
public class KafkaController {

    private final SimpleKafkaProducer producer;

    @Autowired
    public KafkaController(SimpleKafkaProducer producer) {
        this.producer = producer;
    }

    @GetMapping("/send")
    public String send(@RequestParam String message) {
        producer.sendMessage(message);
        return "Message sent: " + message;
    }
}
