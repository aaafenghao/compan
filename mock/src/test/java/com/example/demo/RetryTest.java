package com.example.demo;

import static org.hamcrest.CoreMatchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;


@RunWith(SpringRunner.class)
@SpringBootTest
@WebAppConfiguration
public class RetryTest {
	
	
	private MockMvc mock;
	
	@Autowired
	private WebApplicationContext context;
	
	
	@Before
	public void setup() throws Exception {
		mock = MockMvcBuilders.webAppContextSetup(context).build();
	}
	
	@Test
	public void test(){
		try {
		   this.mock.perform(get("/retry/test").accept(MediaType.ALL)).andExpect(content().string(containsString("Sucess")));
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

}
