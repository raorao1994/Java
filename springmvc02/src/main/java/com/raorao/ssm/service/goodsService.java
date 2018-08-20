package com.raorao.ssm.service;

import java.util.List;

import com.raorao.ssm.po.goods;

public interface goodsService {
	public List<goods> queryList(goods model)throws Exception;
}
