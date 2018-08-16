package com.raorao.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class EncoidingFilter implements Filter {

	private String encoding="";
	
	public void destroy() {
		// TODO 自动生成的方法存根
		
	}
	//过滤方法  是否往下执行
	public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain arg2)
			throws IOException, ServletException {
		// TODO 自动生成的方法存根
		HttpServletRequest request=(HttpServletRequest)arg0;
        HttpServletResponse response=(HttpServletResponse)arg1;
        
        request.setCharacterEncoding(encoding);
        response.setCharacterEncoding(encoding);
        response.getWriter().append("do fielter");

        //过滤通行证
        arg2.doFilter(request, response);
	}

	public void init(FilterConfig arg0) throws ServletException {
		// TODO 自动生成的方法存根
		this.encoding = arg0.getInitParameter("Encoding");
	}

	
}
