package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.retry.RetryDemo;

@RestController
@RequestMapping("retry")
public class RetryController {

	@Autowired
	private RetryDemo retry;
	
	@GetMapping("test")
	public String retry() {
		try {
			retry.retryDemo();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "Sucess";
	}
}
