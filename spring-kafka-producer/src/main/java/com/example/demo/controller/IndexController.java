package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.Producer;

@RestController
public class IndexController {
	
	@Autowired
	private Producer procuder;
	
	@GetMapping("index")
	public String index() {
		procuder.send();
		return "Sucess";
	}

}
