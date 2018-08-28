package com.example.demo.remote;

import org.springframework.stereotype.Component;

@Component
public class HelloRemoteImpl implements HelloRemote {

	@Override
	public String index(String name) {
		return "Send fail";
	}

}
