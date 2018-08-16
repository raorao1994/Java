package com.raorao;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.raorao.model.car;
import com.raorao.model.person;

//bean对象的使用demo
@Controller
@RequestMapping("/bean01")
public class bean01Controller {
	@Autowired
	private person model;
	
	@RequestMapping("GetPerson")
	@ResponseBody
	public String GetPerson(HttpServletRequest request,HttpServletResponse response)
	{
		System.out.println("执行了");
		String str="";
		if(model==null)
		{
			str="model为空";
		}else{
			str=model.getName();
		}
		
		return str;
	}
	
	@RequestMapping("index")
	@ResponseBody
	public String index(HttpServletRequest request,HttpServletResponse response)
	{
		return "inedx";
	}
	
	//必须加上import org.springframework.beans.factory.annotation.Qualifier;
    //@Qualifier注解括号里面的应当是Car接口实现类的类名，但必须小写，否则出错
	@Autowired
	@Qualifier("benz")
	private car c;
	
	@RequestMapping("GetCar")
	@ResponseBody
	public String GetCar(HttpServletRequest request,HttpServletResponse response)
	{
		return c.getCarName();
	}
}
