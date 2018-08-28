package com.example.demo.config;

import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.netflix.hystrix.contrib.metrics.eventstream.HystrixMetricsStreamServlet;

@Configuration
public class HystrixConfig {
	
	    @Bean
	    public HystrixMetricsStreamServlet hystrixMetricsStreamServlet(){
	        return new HystrixMetricsStreamServlet();
	    }

	    @Bean
	    public ServletRegistrationBean<HystrixMetricsStreamServlet> registration(HystrixMetricsStreamServlet servlet){
	        ServletRegistrationBean<HystrixMetricsStreamServlet> registrationBean = new ServletRegistrationBean<HystrixMetricsStreamServlet>();
	        registrationBean.setServlet(servlet);
	        //是否启用该registrationBean
	        registrationBean.setEnabled(true);
	        registrationBean.addUrlMappings("/hystrix.stream");
	        return registrationBean;
	    }

}
