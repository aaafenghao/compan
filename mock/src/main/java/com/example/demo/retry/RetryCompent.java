package com.example.demo.retry;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.remoting.RemoteAccessException;
import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Recover;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Component;

@Component
public class RetryCompent {

	private final static Logger logger = LoggerFactory.getLogger(RetryCompent.class);
	
	
	@Retryable(value = {RemoteAccessException.class},maxAttempts=3,backoff=@Backoff(delay=5000,multiplier=1))
	public void call() throws Exception{
		logger.error("\n"+new Date().toString());
		throw new RemoteAccessException("RPC调用异常");
	}
	
	@Recover
	public void recover(RemoteAccessException e) {
		e.printStackTrace();
	}
}
