package com.raorao.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.raorao.model.Goods;

/*
 * MyBatis SQLӳ���
 * ��Ŀ�����ǲ��ýӿ���xml��ϵ���ʽ��ɹ�ϵ�������ӳ�䣬
 * �ڽӿ��ж���һЩ���ݷ��ʵķ�������xml�ļ��ж���ʵ�����ݷ�����Ҫ��sql�ű���
 * ��Ʒ���ݷ���ӳ��ӿ�����
 * */
public interface GoodsDAO {
	/**
     * �����Ʒ��Ϣ����ҳ
     */
    public List<Goods> getGoodsPager(@Param("skip") int skip,@Param("size") int size);
    
    /**
     * ��õ�����Ʒͨ�����
     */
    public Goods getGoodsById(int id);
    
    /**
     * �����Ʒ����
     */
    public int getGoodsCount();
    
    /**
     * ��������Ʒ
     */
    public int insert(Goods entity);
    
    /**
     * ɾ����Ʒ
     */
    public int delete(int id);
    
    /**
     * �޸���Ʒ
     */
    public int update(Goods entity);
}