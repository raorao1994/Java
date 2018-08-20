package com.raorao.ssm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.raorao.ssm.mapper.goodsMapper;
import com.raorao.ssm.po.goods;
import com.raorao.ssm.service.goodsService;

@Controller
@RequestMapping("/goods")
public class goodsController {
	
	@Autowired
	goodsService server;

	
	@RequestMapping("/list")
	public ModelAndView list()throws Exception{
		
		List<goods> list=server.queryList(null);
		
		ModelAndView mv=new ModelAndView();
		
		mv.setViewName("goods/list");
		
		mv.addObject("list",list);
		
		goods g=new goods();
		g.setId(123);
		g.setName("ÎÒµÄÃû×Ö");
		
		mv.addObject("model",g);
		
		return mv;
	}
}
