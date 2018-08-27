package com.example.demo.async;

import java.util.concurrent.Future;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Component;

@Component
public class AsyncTask {
	
	private final static Logger logger = LoggerFactory.getLogger(AsyncTask.class);
	
	@Async
	public Future<String> task(){
		try {
			logger.error("\ntask run");
			Thread.sleep(10000);
		}catch (Exception e) {
			e.printStackTrace();
		}
		return new AsyncResult<String>("Sucess");
	}
	@Async
	public Future<String> task1(){
		try {
			logger.error("\ntask1 run");
			Thread.sleep(10000);
		}catch (Exception e) {
			e.printStackTrace();
		}
		return new AsyncResult<String>("Sucess");
	}

}
