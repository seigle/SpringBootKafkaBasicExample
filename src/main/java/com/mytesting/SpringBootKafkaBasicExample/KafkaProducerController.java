package com.mytesting.SpringBootKafkaBasicExample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class KafkaProducerController {

	private static final String TOPIC_NAME = "test-topic";
	
	@Autowired
	private KafkaTemplate<String, String> kafkaTemplate;
	
	@GetMapping("/produce")
	public String produceMessage(@RequestParam String message) {
		kafkaTemplate.send(TOPIC_NAME, message);
		return "Message sent to Kafka: " + message;
	}
}
