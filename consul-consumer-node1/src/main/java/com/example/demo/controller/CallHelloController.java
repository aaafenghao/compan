package com.example.demo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class CallHelloController {
	
	private final static Logger logger = LoggerFactory.getLogger(CallHelloController.class);
	
	@Autowired
	private LoadBalancerClient loadBalancer;

	@GetMapping("call")
	public String call() {
		ServiceInstance choose = loadBalancer.choose("service-producers");
		logger.error("address:"+choose.getUri());
		logger.error("name:"+choose.getServiceId());
		String forObject = new RestTemplate().getForObject(choose.getUri().toString()+"/index", String.class);
		logger.error("result:"+forObject);
		return forObject;
	}
}
