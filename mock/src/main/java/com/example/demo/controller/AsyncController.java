package com.example.demo.controller;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.async.AsyncTask;

@RestController
@RequestMapping("async")
public class AsyncController {
	
	private final static Logger logger =  LoggerFactory.getLogger(AsyncController.class);
	
	@Autowired
	private AsyncTask async;
	
	@GetMapping("test")
	public String async() {
		logger.error("\nstart run task");
		task();
		task1();
		task2();
		logger.error("\nend run task");
		return "Sucess";
	}
	
	
	@GetMapping("two")
	public String asyncTwo() throws InterruptedException, ExecutionException {
		logger.error("\nstart run task");
		Future<String> task = async.task();
		Future<String> task1 = async.task1();
		/*for(;;) {
			if(task.isDone() && task1.isDone()) {
				logger.error("\n"+task.get());
				break;
			}
		}*/
		//该方法会阻塞当前线程运行
		task.get();
		task1.get();
		logger.error("\n");
		return "Sucess";
	}
	
	@Async
	public void task() {
		try {
			logger.error("\ntask run");
			Thread.sleep(10000);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Async
	public void task1() {
		try {
			logger.error("\ntask1 run");
			Thread.sleep(10000);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Async
	public void task2() {
		try {
			logger.error("\ntask2 run");
			Thread.sleep(10000);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

}
