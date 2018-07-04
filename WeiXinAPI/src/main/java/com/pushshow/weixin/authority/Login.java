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
 * Ȩ����֤��
 * */
@Controller
@Api(value="Login")
public class Login {
	
	private static Logger logger =Logger.getLogger(Login.class);
	
	@RequestMapping("/authority/index")
	@ApiOperation(value = "���Խӿ�", httpMethod = "GET", response = String.class, notes = "���Խӿ�")
	public void index(HttpServletRequest request,HttpServletResponse response) throws IOException
	{
		response.setHeader("content-type", "text/html;charset=UTF-8");
		response.getWriter().append("���ǵ�¼��֤��Ϣ");
	}
	
	@RequestMapping("/authority/login")
	@ApiOperation(value = "�����û�ID��ȡ�û�����", httpMethod = "GET", response = String.class, notes = "�����û�ID��ȡ�û�����")
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
		
		logger.debug("���Ǵ�����Ϣ");
		logger.info("info��Ϣ");
		
		response.getWriter().append("���ǵ�¼��Ϣ:").append(str);
	}
}
