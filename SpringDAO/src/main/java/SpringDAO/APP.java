package SpringDAO;

import java.util.List;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import SpringDAO.DAO.UserDAO;
import SpringDAO.IDAO.IUserDAO;
import SpringDAO.Model.User;

public class APP {

	public static void main(String[] args) {
		
		dao1();
	}
	
	private static void dao2()
	{
		ApplicationContext context=new FileSystemXmlApplicationContext("F:\\Java\\SpringDAO\\src\\xml\\ApplicationContext.xml");
	    BeanFactory factory =context;
	    UserDAO dao=(UserDAO)factory.getBean("userDao");
	    List<User> list=dao.QueryAllUser(""); 
        for(User u:list)
        {
            System.out.println("name:"+u.getName()+" money: "+u.getMoney());
        }
	}
	
	private static void dao1()
	{
		String path = APP.class.getResource("/").toString(); 
		System.out.println("path = " + path);
		
		// TODO 自动生成的方法存根
		//ApplicationContext context=new ClassPathXmlApplicationContext(new String[]{"ApplicationContext.xml"});
		ApplicationContext context=new FileSystemXmlApplicationContext("F:\\Java\\SpringDAO\\src\\xml\\ApplicationContext.xml");
		
        BeanFactory factory=context;
        IUserDAO userDao=(IUserDAO)factory.getBean("userDao");
        userDao.AddUser("cuiywA",888);
    
        userDao.AddUser("cuiywB",666);
        List<User> list=userDao.QueryAllUser(); 
        for(User u:list)
        {
            System.out.println("name:"+u.getName()+" money: "+u.getMoney());
        }
	}

}
