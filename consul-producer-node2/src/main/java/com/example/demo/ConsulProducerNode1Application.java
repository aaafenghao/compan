package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class ConsulProducerNode1Application {

	public static void main(String[] args) {
		SpringApplication.run(ConsulProducerNode1Application.class, args);
	}
}
