package com.example.demo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("index")
public class IndexCcontroller {
	
	private final static Logger logger =  LoggerFactory.getLogger(IndexCcontroller.class);
	
	@GetMapping(value="test",produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public String index() {
		logger.debug("index test logger");
		return "<a href='http://www.baidu.com'>接口测试</a>";
	}

}
