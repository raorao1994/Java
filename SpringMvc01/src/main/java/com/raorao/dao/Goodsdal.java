package com.raorao.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.raorao.mapper.GoodsDAO;
import com.raorao.model.Goods;
import com.raorao.util.MyBatisUtil;

public class Goodsdal {
	
	SqlSession session=MyBatisUtil.getSession();
	
	public int insert() {
		int result=-1;
        try {
            Goods entity=new Goods();
            entity.setName("正宗无锡阳山水蜜桃新鲜水果水密桃12个6斤装江浙沪皖顺丰包邮");
            entity.setPrice(108);
            entity.setPicture("nopic.jpg");
            GoodsDAO bookdao=session.getMapper(GoodsDAO.class);
            result=bookdao.insert(entity);
        } finally {
            //session.close();
        }
        return result;
    }
	
	public int delete(int id){
		int result=-1;
		try {
            GoodsDAO bookdao=session.getMapper(GoodsDAO.class);
            result= bookdao.delete(id);
        } finally {
            //session.close();
        }
		return result;
	}
	
	public int update(int id) {
		int result=-1;
        try {
            GoodsDAO bookdao=session.getMapper(GoodsDAO.class);
            Goods entity=bookdao.getGoodsById(id);
            entity.setName("正宗无锡阳山水蜜桃新鲜水果水密桃12个6斤装");
            entity.setPrice(107);
            entity.setPicture("nopicture.jpg");

            result= bookdao.update(entity);
        } finally {
            //session.close();
        }
        return result;
    }
	
	public int getGoodsCount() {
		int result=-1;
        try {
            GoodsDAO bookdao=session.getMapper(GoodsDAO.class);
            result=  bookdao.getGoodsCount();
        } finally {
            //session.close();
        }
        return result;
    }
	
	public Goods getGoodsById(int id) {
		Goods result=null;
        try {
            GoodsDAO bookdao=session.getMapper(GoodsDAO.class);
            Goods goods=bookdao.getGoodsById(id);
            result=  goods;
        } finally {
            //session.close();
        }
        return result;
    }
	
	 public List<Goods> getGoodsPager() {
		 List<Goods> result=null;
	        int skip=0;
	        int size=20;
	        try {
	            GoodsDAO bookdao=session.getMapper(GoodsDAO.class);
	            List<Goods> goods=bookdao.getGoodsPager(skip, size);
	            result= goods;
	            System.out.println(goods.size());
	        } finally {
	            //session.close();
	        }
	        return result;
	    }
	
}
