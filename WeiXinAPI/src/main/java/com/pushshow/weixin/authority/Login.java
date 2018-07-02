package com.pushshow.weixin.authority;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.pushshow.weixin.dao.PersonDao;

/*
 * 权限验证包
 * */
@Controller
public class Login {
	
	@RequestMapping("/authority/index")
	public void index(HttpServletRequest request,HttpServletResponse response) throws IOException
	{
		response.setHeader("content-type", "text/html;charset=UTF-8");
		response.getWriter().append("我是登录验证信息");
	}
	
	@RequestMapping("/authority/login")
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
		
		response.getWriter().append("我是登录信息:").append(str);
	}
}
