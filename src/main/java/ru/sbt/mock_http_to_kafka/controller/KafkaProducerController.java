package ru.sbt.mock_http_to_kafka.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.sbt.mock_http_to_kafka.service.KafKaProducerService;

import java.util.HashMap;
import java.util.Map;

/**
 * Класс REST контроллера, тут можно дополнительно прописать запросы для заглушки.
 * Сейчас, чтобы отправить запрос в заглушку надо стучаться по 127.0.0.1:8080/kafka/post?message=text
 */
@RestController
@RequestMapping(value = "/kafka")
public class KafkaProducerController {
    private final KafKaProducerService producerService;

    @Autowired
    public KafkaProducerController(KafKaProducerService producerService) {
        this.producerService = producerService;
    }

    @PostMapping(value = "/post", produces = "application/json")
    public Map<String, String> sendMessageToKafkaTopic(@RequestParam("message") String message) {
        this.producerService.sendMessage(message);
        Map<String, String> response = new HashMap<>();
        response.put("response", "Message successfully sent to Kafka");
        return response;
    }
}