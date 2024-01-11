package com.veta.example.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class KafkaProducerConfig {

	@Bean
	public NewTopic createTopic() {
		return new NewTopic("java-demo-1",5,(short)1);
	}
	
}
