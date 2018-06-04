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
	public SqlHelper(String url,String user,String password){
		this.url=url;
		this.root=user;
		this.pwd=password;
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
	/*
	 * Queryִ��sql��䣬��ȡ����
	 * */
	public <T extends Object> ArrayList<T> Query(T t,String sql)
	{
		
		try {
			//��ȡClass����  
	        Class cls =  Class.forName(t.getClass().getName());
	        //��ȡ���ֶ�
			java.lang.reflect.Field  fields[] = cls.getFields(); 
			//��ȡ�������ݿ����
			Connection conn=GetConnection();
			//����mysqlִ�ж���
			PreparedStatement statement=conn.prepareStatement(sql);
			//ִ��sql���
			ResultSet result=statement.executeQuery();
			//���ض���
			ArrayList<T> result1=new ArrayList<T>();
			while(result.next())
			{
				Object obj=cls.newInstance();
				//Ϊÿһ�������ֶθ�ֵ
				for (int i = 0; i < fields.length; i++) {
					java.lang.reflect.Field field = fields[i];
					String name=field.getName();
					Object val=result.getObject(name);
					field.set(obj,val);
				}
				result1.add((T)obj);
			}
			conn.close();
			return result1;
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}
	}
}
