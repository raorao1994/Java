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

@Api(value = "Goods-Api控制器")
@Controller
@RequestMapping("/Goods")
public class GoodsController {
	
	private Logger logger=Logger.getLogger(this.getClass());
	
	@Autowired
	Goodsdal dao;
	
	@ResponseBody
	@RequestMapping("/getData")
	@ApiResponse(code = 200, message = "success")
	@ApiOperation(value = "getData", response = String.class, notes = "getData-json数据")
	public List<Goods> getData()
	{
		System.out.println("执行了getData");
		List<Goods> data=dao.getGoodsPager();
	
		return data;
	}
	
	@ResponseBody
	@RequestMapping("/getData/{id}")
	@ApiResponse(code = 200, message = "success")
	@ApiOperation( value = "getData", response = Goods.class, notes = "根据id获取数据")
	public Goods getDataById(@PathVariable("id") int id)
	{
		System.out.println("执行了getData");
		Goods data=dao.getGoodsById(id);
		logger.debug("getDataById测试错误");
		logger.info("getDataById测试错误");
		return data;
	}
	
	@ResponseBody
	@RequestMapping(value="/add",method=RequestMethod.GET)
	@ApiResponse(code=200,message="success")
	//@ApiOperation(value = "接口说明", httpMethod = "接口请求方式", response = "接口返回参数类型", notes = "接口发布说明")
	@ApiOperation(value = "添加一条数据", httpMethod = "get", response = int.class, notes = "接口发布说明")
	public int add(){
		System.out.println("执行了add");
		return dao.insert();
	}
	
	@ResponseBody
	@RequestMapping("/delete")
	@ApiResponse(code=200,message="success")
	@ApiOperation(value = "删除一条数据", httpMethod = "get", response = int.class, notes = "接口发布说明")
	public int delete(int id)
	{
		System.out.println("执行了delete");
		return dao.delete(id);
	}
}
