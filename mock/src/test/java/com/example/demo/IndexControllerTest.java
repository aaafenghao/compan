package com.example.demo;

import static org.hamcrest.CoreMatchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import com.example.demo.controller.IndexCcontroller;

@RunWith(SpringRunner.class)
@WebMvcTest(controllers=IndexCcontroller.class)
public class IndexControllerTest {
	
	@Autowired
	private MockMvc mock;
	
	@Test
	public void index() throws Exception{
		ResultActions perform = this.mock.perform(get("/index/test").accept(MediaType.ALL));
		perform.andReturn().getResponse().setCharacterEncoding("utf-8");
		perform.andDo(print()).andExpect(status().isOk()).andExpect(content().string(containsString("接口")));
	}

}
