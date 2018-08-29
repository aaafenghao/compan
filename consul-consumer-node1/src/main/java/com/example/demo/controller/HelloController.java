package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
	
	@Autowired
	private LoadBalancerClient loadBalancer;
	
	@Autowired
	private DiscoveryClient discoveryClient;
	
	/**
	 * 
	 * <p>Title: services</p>
	 * <p>Description: 获取所有服务信息</p>
	 * @return
	 * @author 冯浩  2018年8月29日 下午1:55:57
	 */
	@RequestMapping("/services")
	public Object services() {
		return discoveryClient.getInstances("service-producers");
	}
	@RequestMapping("/discover")
	public Object discover() {
		return loadBalancer.choose("service-producers").getUri().toString();
	}

}
