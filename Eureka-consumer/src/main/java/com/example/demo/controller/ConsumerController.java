package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.remote.HelloRemote;

@RestController
public class ConsumerController {

	@Autowired
	private HelloRemote remote;
	
	@GetMapping("test")
	public String testConsumer(String test) {
		return remote.index(test);
	}
}
