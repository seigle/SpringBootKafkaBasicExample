package com.mytesting.SpringBootKafkaBasicExample;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaConsumer {

	private static final String TOPIC_NAME = "test-topic";
	
	@KafkaListener(topics = TOPIC_NAME, groupId = "group_id")
	public void consume(String message) {
		System.out.println("Received message from Kafka: " + message);
	}
}
