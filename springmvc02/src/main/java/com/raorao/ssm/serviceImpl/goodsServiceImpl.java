package com.raorao.ssm.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.raorao.ssm.mapper.goodsMapper;
import com.raorao.ssm.po.goods;
import com.raorao.ssm.service.goodsService;

public class goodsServiceImpl implements goodsService {
	
	@Autowired
	goodsMapper dao;
	
	public List<goods> queryList(goods model) throws Exception {
		// TODO �Զ����ɵķ������
		return dao.queryList(model);
	}

}
