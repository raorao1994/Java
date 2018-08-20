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

//其他通用demo
@Api(value = "Api控制器")
@Controller
@RequestMapping("/index")
public class IndexController {
	String message="欢迎进入springmvc程序";
	
	@RequestMapping("/showMessage")
	public ModelAndView showMessage(@RequestParam(value="name",required=false,defaultValue="spring") String name)
	{
		ModelAndView mv=new ModelAndView("index");//指定试图
		//向视图中添加所要展示或使用的内容，将在页面中使用
        mv.addObject("message", message);
        mv.addObject("name", name);
        return mv;
	}
	
	@ResponseBody
	@RequestMapping("/hello")
	public String hello(HttpServletRequest request,HttpServletResponse response)throws IOException{
		//response.setContentType("application/json;charset=UTF-8");
		System.out.println("执行了");
		//response.getWriter().append("这里是hello");
		return "这里是hello";
	}
	
	//rest服务
	@ResponseBody
	@RequestMapping("/rest/{id}")
	public String rest(@PathVariable("id") Integer id){
		//response.setContentType("application/json;charset=UTF-8");
		System.out.println("执行了");
		//response.getWriter().append("这里是hello");
		return "id="+id.toString();
	}
	
    //rest服务返回json格式数据
	@ResponseBody
	@RequestMapping("/json")
	@ApiResponse(code = 200, message = "success", response = person.class)
	@ApiOperation(value = "返回json数据", response = String.class, notes = "返回json数据")
	public person json(){
		//response.setContentType("application/json;charset=UTF-8");
		System.out.println("执行了json");
		//response.getWriter().append("这里是hello");
		person p=new person();
		p.setName("王小二");
		p.setAge(123);
		return p;
	}
}
