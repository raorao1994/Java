package com.raorao;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.raorao.dao.Goodsdal;
import com.raorao.model.Goods;
import com.raorao.model.person;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;

@Api(value = "Goods-Api������")
@Controller
@RequestMapping("/Goods")
public class GoodsController {
	
	private Logger logger=Logger.getLogger(this.getClass());
	
	@Autowired
	Goodsdal dao;
	
	@ResponseBody
	@RequestMapping("/getData")
	@ApiResponse(code = 200, message = "success")
	@ApiOperation(value = "getData", response = String.class, notes = "getData-json����")
	public List<Goods> getData()
	{
		System.out.println("ִ����getData");
		List<Goods> data=dao.getGoodsPager();
	
		return data;
	}
	
	@ResponseBody
	@RequestMapping("/getData/{id}")
	@ApiResponse(code = 200, message = "success")
	@ApiOperation( value = "getData", response = Goods.class, notes = "����id��ȡ����")
	public Goods getDataById(@PathVariable("id") int id)
	{
		System.out.println("ִ����getData");
		Goods data=dao.getGoodsById(id);
		logger.debug("getDataById���Դ���");
		logger.info("getDataById���Դ���");
		return data;
	}
	
	@ResponseBody
	@RequestMapping(value="/add",method=RequestMethod.GET)
	@ApiResponse(code=200,message="success")
	//@ApiOperation(value = "�ӿ�˵��", httpMethod = "�ӿ�����ʽ", response = "�ӿڷ��ز�������", notes = "�ӿڷ���˵��")
	@ApiOperation(value = "���һ������", httpMethod = "get", response = int.class, notes = "�ӿڷ���˵��")
	public int add(){
		System.out.println("ִ����add");
		return dao.insert();
	}
	
	@ResponseBody
	@RequestMapping("/delete")
	@ApiResponse(code=200,message="success")
	@ApiOperation(value = "ɾ��һ������", httpMethod = "get", response = int.class, notes = "�ӿڷ���˵��")
	public int delete(int id)
	{
		System.out.println("ִ����delete");
		return dao.delete(id);
	}
}
