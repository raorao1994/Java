package com.pushshow.weixin.dao;

import org.apache.ibatis.session.SqlSession;

import com.pushshow.weixin.entity.Person;
import com.pushshow.weixin.mapping.IPersonMapping;

public class PersonDao {
	
	@SuppressWarnings("finally")
	public String getentity(int id)
	{
		String result="";
		SqlSession session = GetSqlSessionFactory.getSqlSessionFactory().openSession();
		try
		{
			Person entity=session.getMapper(IPersonMapping.class).getentity(id);
			//session.commit();// 提交事务
			result=entity.getName();
			//result=new JSONUtils().getJsonByListObj(entity);
		} 
		catch (Exception e)
		{
			result="发生错误，未获取到数据";
			e.printStackTrace();
		} 
		finally
		{
			session.close();
			return result;
		}

	}
}
