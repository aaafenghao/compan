package com.example.demo.service;

import java.util.Date;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

@Component
public class Producer {
	
	@Autowired
	private KafkaTemplate<String,Object> template;
	
	private static Gson gson = new GsonBuilder().create();
	
	public void send() {
		Message message = new Message();
		message.setId("KFK"+System.currentTimeMillis());
		message.setMsg(UUID.randomUUID().toString());
		message.setDate(new Date());
		template.send("test", gson.toJson(message));
	}
	
	public class Message{
		private String id;
		
		private String msg;
		
		private Date date;

		public String getId() {
			return id;
		}

		public void setId(String id) {
			this.id = id;
		}

		public String getMsg() {
			return msg;
		}

		public void setMsg(String msg) {
			this.msg = msg;
		}

		public Date getDate() {
			return date;
		}

		public void setDate(Date date) {
			this.date = date;
		}

		
		
	}

}


