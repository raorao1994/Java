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

//bean�����ʹ��demo
@Controller
@RequestMapping("/bean01")
public class bean01Controller {
	@Autowired
	private person model;
	
	@RequestMapping("GetPerson")
	@ResponseBody
	public String GetPerson(HttpServletRequest request,HttpServletResponse response)
	{
		System.out.println("ִ����");
		String str="";
		if(model==null)
		{
			str="modelΪ��";
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
	
	//�������import org.springframework.beans.factory.annotation.Qualifier;
    //@Qualifierע�����������Ӧ����Car�ӿ�ʵ�����������������Сд���������
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
