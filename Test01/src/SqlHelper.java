import java.awt.Window.Type;
import java.sql.*;
import java.util.*;

import com.mysql.jdbc.Field;
/*
 * mysql数据库操作帮助类
 * */
public class SqlHelper {
	private String url="";
	private String root="";
	private String pwd="";
	
	/*
	 * 构造方法
	 * */
	public SqlHelper(String url,String user,String password){
		this.url=url;
		this.root=user;
		this.pwd=password;
	}
	
	/*
	 * 获取数据库连接对象
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
	 * Query执行sql语句，获取数据
	 * */
	public <T extends Object> ArrayList<T> Query(T t,String sql)
	{
		
		try {
			//获取Class对象  
	        Class cls =  Class.forName(t.getClass().getName());
	        //获取类字段
			java.lang.reflect.Field  fields[] = cls.getFields(); 
			//获取连接数据库对象
			Connection conn=GetConnection();
			//创建mysql执行对象
			PreparedStatement statement=conn.prepareStatement(sql);
			//执行sql语句
			ResultSet result=statement.executeQuery();
			//返回对象
			ArrayList<T> result1=new ArrayList<T>();
			while(result.next())
			{
				Object obj=cls.newInstance();
				//为每一个对象字段赋值
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
