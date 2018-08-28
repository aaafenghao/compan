package com.example.demo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
	
	private final static Logger logger = LoggerFactory.getLogger(HelloController.class);
	
	@GetMapping("/index/{name}")
	public String index(@PathVariable("name")String name) {
		logger.error("\nparam "+name);
		return name+" Sucess";
	}

}
