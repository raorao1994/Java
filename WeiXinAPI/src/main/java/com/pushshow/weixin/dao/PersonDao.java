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
			//session.commit();// �ύ����
			result=entity.getName();
			//result=new JSONUtils().getJsonByListObj(entity);
		} 
		catch (Exception e)
		{
			result="��������δ��ȡ������";
			e.printStackTrace();
		} 
		finally
		{
			session.close();
			return result;
		}

	}
}
