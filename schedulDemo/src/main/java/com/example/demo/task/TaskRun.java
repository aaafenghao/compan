package com.example.demo.task;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.Scheduled;

@Configuration
public class TaskRun {

	private final static Logger logger = LoggerFactory.getLogger(TaskRun.class);
	
	@Scheduled(fixedDelay=10000)
	public void task1() {
		logger.error("\nrun task1");
		logger.error("\ntask1"+new Date().toString());
	}
	
	@Scheduled(fixedDelay=10000)
	public void task2() {
		logger.error("\nrun task2");
		logger.error("\ntask2"+new Date().toString());
	}

}
