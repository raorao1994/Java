package com.raorao.ssm.mapper;

import java.util.List;

import com.raorao.ssm.po.goods;

public interface goodsMapper{
	
	public List<goods> queryList(goods model)throws Exception;
}
