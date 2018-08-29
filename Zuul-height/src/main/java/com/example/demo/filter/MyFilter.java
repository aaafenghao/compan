package com.example.demo.filter;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.FilterType;
import org.springframework.util.StringUtils;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

public class MyFilter extends ZuulFilter {
	
	private final static Logger logger = LoggerFactory.getLogger(MyFilter.class);

	@Override
	public Object run() throws ZuulException {
		RequestContext currentContext = RequestContext.getCurrentContext();
		HttpServletRequest request = currentContext.getRequest();
		String test = request.getParameter("test");
		logger.error("\nget parameter "+test);
		if(StringUtils.hasText(test)) {
			logger.error("\nzuul respopnse true");
			//对请求进行路由
			currentContext.setSendZuulResponse(true);
			currentContext.setResponseStatusCode(200);
			currentContext.set("isSucess", true);
			return null;
		}else {
			logger.error("\nzuul response false");
			//不对其进行路由
			currentContext.setSendZuulResponse(false);
			currentContext.setResponseStatusCode(400);
			currentContext.setResponseBody("test param is empty");
			currentContext.set("isSucess", false);
			return null;
		}
	
	}

	@Override
	public boolean shouldFilter() {
		//表示是否需要执行该filter,true表示执行
		return true;
	}

	@Override
	public int filterOrder() {
		return 0;
	}

	@Override
	public String filterType() {
		return "pre";
	}

}
