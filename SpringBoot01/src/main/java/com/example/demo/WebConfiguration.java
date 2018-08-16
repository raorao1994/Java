package com.example.demo;

import org.apache.catalina.filters.RemoteIpFilter;
import org.springframework.boot.context.embedded.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class WebConfiguration {
	
	@Bean
	public RemoteIpFilter remoteIpFilter()
	{
		return new RemoteIpFilter();
	}
	
//	@Bean
//	public FilterRegistrationBean testFilterRegistration()
//	{
//		FilterRegistrationBean registration=new FilterRegistrationBean();
//		
//	}
}


