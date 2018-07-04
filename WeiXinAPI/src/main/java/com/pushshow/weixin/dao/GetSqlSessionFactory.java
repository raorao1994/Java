package com.pushshow.weixin.dao;

import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class GetSqlSessionFactory {
	
	private static SqlSessionFactory sqlSessionFactory=null;
	
	private static GetSqlSessionFactory getSqlSessionFactory=null;
	
	private  GetSqlSessionFactory()
	{
		String re="mybatis-config.xml";
		Reader read=null;
		try
		{
			read=Resources.getResourceAsReader(re);
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}

		sqlSessionFactory=new SqlSessionFactoryBuilder().build(read);
	}
	
	public static GetSqlSessionFactory getInstance()
	{
		if (getSqlSessionFactory == null)
			getSqlSessionFactory = new GetSqlSessionFactory();
		return getSqlSessionFactory;
	}
 
	public static SqlSessionFactory getSqlSessionFactory()
	{
		if(sqlSessionFactory==null)
		{
			getInstance();
		}
		return sqlSessionFactory;
	}

}
