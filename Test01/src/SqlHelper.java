import java.awt.Window.Type;
import java.sql.*;
import java.util.*;

import com.mysql.jdbc.Field;
/*
 * mysql���ݿ����������
 * */
public class SqlHelper {
	private String url="";
	private String root="";
	private String pwd="";
	
	/*
	 * ���췽��
	 * */
	public SqlHelper(String url,String root,String pwd){
		this.url=url;
		this.root=root;
		this.pwd=pwd;
	}
	
	/*
	 * ��ȡ���ݿ����Ӷ���
	 * */
	private Connection GetConnection()
	{
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn=DriverManager.getConnection(this.url,this.root,this.pwd);
			return conn;
		}catch(Exception ex){
			
			return null;
		}
		
	}
	
	public <T extends Object> List<T> Query(String sql)
	{
		
		try {
			T o = null;
			//��ȡClass����  
	        Class cls =  Class.forName(o.getClass().getName());
			java.lang.reflect.Field  fields[] = cls.getDeclaredFields(); 
			Connection conn=GetConnection();
			PreparedStatement statement=conn.prepareStatement(sql);
			ResultSet result=statement.executeQuery();
			while(result.next())
			{
				result.getString("");
				Object obj=cls.newInstance();
				
			}
			conn.close();
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}
		return null;
	}
}
