package com.example.demo.retry;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RetryDemo {
	
	@Autowired
	private RetryCompent retry;
	
	public void retryDemo() throws Exception {
		retry.call();
	}

}
