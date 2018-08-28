package com.example.demo.config;

import org.springframework.context.annotation.Configuration;


@Configuration
public class HystrixConfig {
	
	  /*  @Bean
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
	    }*/

}
