package com.example.demo.router;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import com.example.demo.handler.HelloHandler;

@Configuration
public class HelloRouter {
	
	@Autowired
	private HelloHandler hello;
	
	@Bean
	public RouterFunction<ServerResponse> routerHello(){
		return RouterFunctions.route(RequestPredicates.GET("/index")
				.and(RequestPredicates.accept(MediaType.TEXT_PLAIN)), hello::hello);
	}

}
