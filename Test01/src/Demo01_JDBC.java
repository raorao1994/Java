import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.*;
import java.util.Properties;

public class Demo01_JDBC {
	
	//���������ַ���
	// jdbcЭ��:���ݿ���Э��:����:�˿�/���ӵ����ݿ�   //
	static String url="jdbc:mysql://localhost:3306/test";
	
	static String user="root";//�û�
	static String password="1212";//����

	public static void main(String[] args) {
		// TODO �Զ����ɵķ������
		System.out.println("�����ҵ����");
		
		try{
			//test1();
			//test02();
			//test03();
			
			
			ReadData01();
			insert();
			update();
			delete();
			System.out.println("���ӳɹ�");
		}catch(Exception ex){
			
			System.out.println("���ӳ���");
		}
		
	}
	
	/**
	* ��һ�ַ���
	* @throws Exception
	*/
	public static void test1() throws Exception{
		//1�����������������
		Driver driver=new com.mysql.jdbc.Driver();//�°汾
		//Driver driver = new org.gjt.mm.mysql.Driver(); //�ɰ汾
		
		//������������
		Properties props=new Properties();
		props.setProperty("user", user);
		props.setProperty("password", password);
		
		//2���������ݿ�
		Connection conn=driver.connect(url, props);
		System.out.println(conn);
	}
	/*
	 * �ڶ��ַ���
	 * ʹ���������������������ݿ�
	 * */
	public static void test02() throws Exception{
		
		Driver driver1=new com.mysql.jdbc.Driver();
		 //1.ע����������(����ע������������)
		DriverManager.registerDriver(driver1);
		
		//2�����ӵ���������ݿ�
		Connection conn=DriverManager.getConnection(url,user,password);
		System.out.println(conn);
	}
	/*
	 * �����ַ������Ƽ�ʹ��
	 * �Ƽ����ü�������������ע����������
	 * */
	public static void test03() throws Exception{
		//ͨ���õ��ֽ������ķ�ʽ���ؾ�̬����飬�Ӷ�ע����������
		Class.forName("com.mysql.jdbc.Driver");
		//���ӵ��������ݿ�
		Connection conn=DriverManager.getConnection(url,user,password);
		System.out.println(conn);
	}
	/*
	 * �����Ƽ������������ݿ⣬��ȡ����
	 * */
	public static void ReadData01() throws Exception{
		
		//������������
		Class.forName("com.mysql.jdbc.Driver");
		//��ȡ���Ӷ���
		Connection conn=DriverManager.getConnection(url,user,password);
		//����statement���������ִ��sql���
		Statement statement=conn.createStatement();
		if(conn.isClosed()){
			System.out.println("δ����");
			return;
		}
		String sql="select * from person";
		//3��ResultSet�࣬������ŷ��ؽ��
		ResultSet rs=statement.executeQuery(sql);
		System.out.println("----------------------------");
		System.out.println("ִ�н��������ʾ:");  
		System.out.println("-----------------");  
		System.out.println("����" + "\t" + "����"+"\t�Ա�");  
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
		System.out.println("���ݿ����ݳɹ���ȡ����");
	}
	
	/*��������*/
	public static void insert() throws Exception
	{
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn=DriverManager.getConnection(url,user,password);
		
		if(conn.isClosed()){
			
			System.out.println("����ʧ��");
			return ;
		}
		String sql="insert into person (name,age,sex) values(?,?,?);";
		PreparedStatement psmt=conn.prepareStatement(sql);
		
		psmt.setString(1,"С��");
		psmt.setInt(2,22);
		psmt.setBoolean(3, false);
		int i=psmt.executeUpdate();
		if(i==1)
			System.out.println("����ɹ�");
		else
			System.out.println("����ʧ��");
	}
	
	/*��������*/
	public static void update() throws Exception{
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn=DriverManager.getConnection(url,user,password);
		
		if(conn.isClosed()){
			
			System.out.println("����ʧ��");
			return ;
		}
		String sql="update person set name= ? where name='Сû' ;";
		PreparedStatement psmt=conn.prepareStatement(sql);
		
		psmt.setString(1,"С��");
		int i=psmt.executeUpdate();
		if(i==1)
			System.out.println("�޸ĳɹ�");
		else
			System.out.println("�޸�ʧ��");
		
	}
	/*ɾ������*/
	public static void delete() throws Exception{
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn=DriverManager.getConnection(url,user,password);
		
		if(conn.isClosed()){
			
			System.out.println("����ʧ��");
			return ;
		}
		String sql="delete from person where name='С��';";
		PreparedStatement psmt=conn.prepareStatement(sql);
		int i=psmt.executeUpdate();
		if(i>=1)
			System.out.println("ɾ���ɹ�");
		else
			System.out.println("ɾ��ʧ��");
		
	}
}
