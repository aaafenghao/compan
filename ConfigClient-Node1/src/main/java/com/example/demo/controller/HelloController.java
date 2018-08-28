package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope //手动刷新配置文件
public class HelloController {
	
	@Value("${neo.hello}")
	private String hello;
	
	@GetMapping("index")
	public String index() {
		return this.hello;
	}

}
