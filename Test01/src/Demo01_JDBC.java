import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.*;
import java.util.Properties;

public class Demo01_JDBC {
	
	//设置连接字符串
	// jdbc协议:数据库子协议:主机:端口/连接的数据库   //
	static String url="jdbc:mysql://localhost:3306/test";
	
	static String user="root";//用户
	static String password="1212";//密码

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		System.out.println("这是我的输出");
		
		try{
			//test1();
			//test02();
			//test03();
			
			
			ReadData01();
			insert();
			update();
			delete();
			System.out.println("连接成功");
		}catch(Exception ex){
			
			System.out.println("连接出错");
		}
		
	}
	
	/**
	* 第一种方法
	* @throws Exception
	*/
	public static void test1() throws Exception{
		//1、创建驱动程序对象
		Driver driver=new com.mysql.jdbc.Driver();//新版本
		//Driver driver = new org.gjt.mm.mysql.Driver(); //旧版本
		
		//设置连接属性
		Properties props=new Properties();
		props.setProperty("user", user);
		props.setProperty("password", password);
		
		//2、连接数据库
		Connection conn=driver.connect(url, props);
		System.out.println(conn);
	}
	/*
	 * 第二种方法
	 * 使用驱动管理器，连接数据库
	 * */
	public static void test02() throws Exception{
		
		Driver driver1=new com.mysql.jdbc.Driver();
		 //1.注册驱动程序(可以注册多个驱动程序)
		DriverManager.registerDriver(driver1);
		
		//2、连接到具体的数据库
		Connection conn=DriverManager.getConnection(url,user,password);
		System.out.println(conn);
	}
	/*
	 * 第三种方法，推荐使用
	 * 推荐采用加载驱动程序来注册驱动程序
	 * */
	public static void test03() throws Exception{
		//通过得到字节码对象的方式加载静态代码块，从而注册驱动程序
		Class.forName("com.mysql.jdbc.Driver");
		//连接道具体数据库
		Connection conn=DriverManager.getConnection(url,user,password);
		System.out.println(conn);
	}
	/*
	 * 采用推荐方法连接数据库，读取数据
	 * */
	public static void ReadData01() throws Exception{
		
		//加载驱动程序
		Class.forName("com.mysql.jdbc.Driver");
		//获取连接对象
		Connection conn=DriverManager.getConnection(url,user,password);
		//创建statement类对象，用来执行sql语句
		Statement statement=conn.createStatement();
		if(conn.isClosed()){
			System.out.println("未连接");
			return;
		}
		String sql="select * from person";
		//3、ResultSet类，用来存放返回结果
		ResultSet rs=statement.executeQuery(sql);
		System.out.println("----------------------------");
		System.out.println("执行结果如下所示:");  
		System.out.println("-----------------");  
		System.out.println("姓名" + "\t" + "年龄"+"\t性别");  
		System.out.println("----------------------------"); 
		String name;
		int age;
		boolean sex;
		while(rs.next())
		{
			name=rs.getString("name");
			age=rs.getInt("age");
			sex=rs.getBoolean("sex");
			System.out.println(name+"\t"+age+"\t"+sex);
		}
		rs.close();
		conn.close();
		System.out.println("数据库数据成功获取！！");
	}
	
	/*插入数据*/
	public static void insert() throws Exception
	{
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn=DriverManager.getConnection(url,user,password);
		
		if(conn.isClosed()){
			
			System.out.println("连接失败");
			return ;
		}
		String sql="insert into person (name,age,sex) values(?,?,?);";
		PreparedStatement psmt=conn.prepareStatement(sql);
		
		psmt.setString(1,"小美");
		psmt.setInt(2,22);
		psmt.setBoolean(3, false);
		int i=psmt.executeUpdate();
		if(i==1)
			System.out.println("插入成功");
		else
			System.out.println("插入失败");
	}
	
	/*更新数据*/
	public static void update() throws Exception{
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn=DriverManager.getConnection(url,user,password);
		
		if(conn.isClosed()){
			
			System.out.println("连接失败");
			return ;
		}
		String sql="update person set name= ? where name='小没' ;";
		PreparedStatement psmt=conn.prepareStatement(sql);
		
		psmt.setString(1,"小张");
		int i=psmt.executeUpdate();
		if(i==1)
			System.out.println("修改成功");
		else
			System.out.println("修改失败");
		
	}
	/*删除数据*/
	public static void delete() throws Exception{
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn=DriverManager.getConnection(url,user,password);
		
		if(conn.isClosed()){
			
			System.out.println("连接失败");
			return ;
		}
		String sql="delete from person where name='小美';";
		PreparedStatement psmt=conn.prepareStatement(sql);
		int i=psmt.executeUpdate();
		if(i>=1)
			System.out.println("删除成功");
		else
			System.out.println("删除失败");
		
	}
}
