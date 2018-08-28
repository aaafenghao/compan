package com.example.demo.remote;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name="spring-cloud-producer")
public interface HelloRemote {
	
	@GetMapping("/index/{name}")
	public String index(@PathVariable("name")String name);

}
