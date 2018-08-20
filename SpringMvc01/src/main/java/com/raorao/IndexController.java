package com.raorao;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.raorao.model.person;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;

//����ͨ��demo
@Api(value = "Api������")
@Controller
@RequestMapping("/index")
public class IndexController {
	String message="��ӭ����springmvc����";
	
	@RequestMapping("/showMessage")
	public ModelAndView showMessage(@RequestParam(value="name",required=false,defaultValue="spring") String name)
	{
		ModelAndView mv=new ModelAndView("index");//ָ����ͼ
		//����ͼ�������Ҫչʾ��ʹ�õ����ݣ�����ҳ����ʹ��
        mv.addObject("message", message);
        mv.addObject("name", name);
        return mv;
	}
	
	@ResponseBody
	@RequestMapping("/hello")
	public String hello(HttpServletRequest request,HttpServletResponse response)throws IOException{
		//response.setContentType("application/json;charset=UTF-8");
		System.out.println("ִ����");
		//response.getWriter().append("������hello");
		return "������hello";
	}
	
	//rest����
	@ResponseBody
	@RequestMapping("/rest/{id}")
	public String rest(@PathVariable("id") Integer id){
		//response.setContentType("application/json;charset=UTF-8");
		System.out.println("ִ����");
		//response.getWriter().append("������hello");
		return "id="+id.toString();
	}
	
    //rest���񷵻�json��ʽ����
	@ResponseBody
	@RequestMapping("/json")
	@ApiResponse(code = 200, message = "success", response = person.class)
	@ApiOperation(value = "����json����", response = String.class, notes = "����json����")
	public person json(){
		//response.setContentType("application/json;charset=UTF-8");
		System.out.println("ִ����json");
		//response.getWriter().append("������hello");
		person p=new person();
		p.setName("��С��");
		p.setAge(123);
		return p;
	}
}
