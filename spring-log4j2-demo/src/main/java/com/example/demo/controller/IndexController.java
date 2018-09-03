package com.example.demo.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(value="测试接口")
@RestController
public class IndexController {

	private final static Logger logger = LogManager.getLogger(IndexController.class);
	
	@ApiOperation(notes="index", value = "test")
	@GetMapping("index")
	public String index(HttpServletRequest request,HttpServletResponse response) {
		StringBuffer requestURL = request.getRequestURL();
		requestURL.append("?");
		Map<String, String[]> parameterMap = request.getParameterMap();
		parameterMap.forEach((key,value) ->{
//			logger.error(String.format("%s-%s", key,value));
			requestURL.append(key+"="+value.toString()).append("&");
		});
		String substring = requestURL.toString().substring(0,requestURL.toString().length()-1);
		logger.error(substring);
		logger.error("URL:"+requestURL.toString());
		String requestURI = request.getRequestURI();
		logger.error("URI:"+requestURI);
		logger.debug("dasdasd");
		return "Sucess";
	}
}
