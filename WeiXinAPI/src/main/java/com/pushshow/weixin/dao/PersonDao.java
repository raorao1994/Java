package com.pushshow.weixin.dao;

import org.apache.ibatis.session.SqlSession;

import com.pushshow.weixin.entity.Person;
import com.pushshow.weixin.mapping.PersonMapping;

import net.sf.json.util.JSONUtils;

public class PersonDao {
	
	public String getentity(int id)
	{
		String result="";
		SqlSession session = GetSqlSessionFactory.getInstance().getSqlSessionFactory().openSession();
		try
		{
			Person entity=session.getMapper(PersonMapping.class).getentity(10);
			//session.commit();// 提交事务
			result=entity.getName();
			//result=new JSONUtils().getJsonByListObj(entity);
			
		} catch (Exception e)
		{
			e.printStackTrace();
		} finally
		{
			session.close();
			return result;
		}

	}
}
