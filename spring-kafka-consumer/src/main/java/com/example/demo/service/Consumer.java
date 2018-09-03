package com.example.demo.service;



import java.io.IOException;
import java.util.Optional;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class Consumer {
	
	private final static Logger logger = LoggerFactory.getLogger(Consumer.class);

	@KafkaListener(topics= {"test"})
	public  void listen(ConsumerRecord<?, ?> record) throws IOException {
		Optional<?> message = Optional.ofNullable(record.value());
		if(message.isPresent()) {
			Object object = message.get();
			logger.error(object.toString());
		}
	
	}

}


