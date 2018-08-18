package com.example.demo;

import static org.mockito.Mockito.when;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.model.User;
import com.example.demo.service.UserService;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {MockApplication.class})
public class SimulcationTest {
	
	private final static Logger logger = LoggerFactory.getLogger(SimulcationTest.class);
	
	@Mock
	private UserService userSerice;
	
	
	@Before
	public void setup() throws Exception{
		User user = new User();
		user.setId(1);
		user.setName("fenghao");
		when(userSerice.findOne(1)).thenReturn(user);
		
	}
	
	@Test
	public void test() {
		User findOne = userSerice.findOne(1);
		logger.error("findOne 1");
		Assert.assertEquals(findOne.getName(), "fenghao");
	}
	

}
