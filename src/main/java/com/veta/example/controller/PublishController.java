package com.veta.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.veta.example.service.KafkaMessagePublisher;

@RestController
public class PublishController {
	
	@Autowired
	private KafkaMessagePublisher publisher;
	
	@GetMapping("/publish/{message}")
	public ResponseEntity<?> getProducerMessage(@PathVariable String message ){
		
		try {
			for(int i=0;i<1000;i++) {
				publisher.sendMessagetoTopic(message+" Value of i=" +i);
			}
		
			return ResponseEntity.ok("message published succesfully");
		}
		catch(Exception e ) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}

}
