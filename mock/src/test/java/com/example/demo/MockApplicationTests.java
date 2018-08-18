package com.example.demo;

import static org.hamcrest.CoreMatchers.containsString;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultHandler;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.example.demo.controller.IndexCcontroller;

@RunWith(SpringRunner.class)
@SpringBootTest
@WebAppConfiguration()
public class MockApplicationTests {

	private final static Logger logger = LoggerFactory.getLogger(MockApplicationTests.class);
	
	@Test
	public void contextLoads() {
	}
	
	private MockMvc mock;
	
	/*@Autowired
	private WebApplicationContext content;*/
	
	@Before
	public void setup() throws Exception{
		mock = MockMvcBuilders.standaloneSetup(IndexCcontroller.class).build();
//		MockMvcBuilders.webAppContextSetup(content).build();
	}
	
	@Test
	public void test() throws Exception{
		this.mock.perform(MockMvcRequestBuilders.get("/index/test").accept(MediaType.ALL)).andDo(new ResultHandler() {
			
			@Override
			public void handle(MvcResult result) throws Exception {
				String contentAsString = result.getResponse().getContentAsString();
				logger.error(contentAsString);
			}
		}).andExpect(content().string(containsString("接口")));
	}

}
