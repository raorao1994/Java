package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.Person;
import com.example.entity.Test;

@RestController
@RequestMapping("/person")
public class PersonController {
	
	@RequestMapping("/GetPersonById")
	public Person GetPersonById()
	{
		Person p=new Person();
		p.setAge(12);
		p.setId(12);
		p.setName("cxw");
		return p;
	}
	
	@Autowired
	Test basetest;
	
	@RequestMapping("/testfunc")
	public Test testfunc()
	{
		//Test t=new Test();
		return basetest;
	}
}
