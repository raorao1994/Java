package com.raorao.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.raorao.model.Goods;

/*
 * MyBatis SQL映射层
 * 项目中我们采用接口与xml结合的形式完成关系与对象间的映射，
 * 在接口中定义一些数据访问的方法，在xml文件中定义实现数据访问需要的sql脚本。
 * 商品数据访问映射接口如下
 * */
public interface GoodsDAO {
	/**
     * 获得商品信息并分页
     */
    public List<Goods> getGoodsPager(@Param("skip") int skip,@Param("size") int size);
    
    /**
     * 获得单个商品通过编号
     */
    public Goods getGoodsById(int id);
    
    /**
     * 获得商品总数
     */
    public int getGoodsCount();
    
    /**
     * 新增加商品
     */
    public int insert(Goods entity);
    
    /**
     * 删除商品
     */
    public int delete(int id);
    
    /**
     * 修改商品
     */
    public int update(Goods entity);
}
