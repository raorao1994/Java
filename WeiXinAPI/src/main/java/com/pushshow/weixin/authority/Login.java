package com.pushshow.weixin.authority;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.pushshow.weixin.dao.PersonDao;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;

/*
 * 权限验证包
 * */
@Controller
@Api(value="Login")
public class Login {
	
	private static Logger logger =Logger.getLogger(Login.class);
	
	@RequestMapping("/authority/index")
	@ApiOperation(value = "测试接口", httpMethod = "GET", response = String.class, notes = "测试接口")
	public void index(HttpServletRequest request,HttpServletResponse response) throws IOException
	{
		response.setHeader("content-type", "text/html;charset=UTF-8");
		response.getWriter().append("我是登录验证信息");
	}
	
	@RequestMapping("/authority/login")
	@ApiOperation(value = "根据用户ID获取用户对象", httpMethod = "GET", response = String.class, notes = "根据用户ID获取用户对象")
	public void login(HttpServletRequest request,HttpServletResponse response) throws IOException
	{
		response.setHeader("content-type", "text/html;charset=UTF-8");
		
		String str="";
		PersonDao pd=new PersonDao();
		String id=request.getParameter("id");
		int a=1;
		try {
		    a = Integer.parseInt(id);
		} catch (NumberFormatException e) {
		    e.printStackTrace();
		}
		str=pd.getentity(a);
		
		logger.debug("这是错误信息");
		logger.info("info信息");
		
		response.getWriter().append("我是登录信息:").append(str);
	}
}
