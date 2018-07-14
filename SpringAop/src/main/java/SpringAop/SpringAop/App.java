package SpringAop.SpringAop;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import Spring.IService.IFunc;
import Spring.IService.IService;
import Spring.Service.Console2Log;
import Spring.Service.ConsoleLog;
import Spring.Service.Func;
import Spring.Service.LifeCycle;
import Spring.Service.ServiceImpl;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        
        //testBean();
        //LiftCycle();
        //proxyText();
        aop();
    }
    
    /*
     * 切面
     * */
    public static void aop()
    {
    	 ApplicationContext context=new FileSystemXmlApplicationContext("E:\\SVN\\Java\\trunk\\SpringAop\\src\\xml\\ApplicationContext1.xml");
    	 //ApplicationContext context=new ClassPathXmlApplicationContext(new String[]{"ApplicationContext1.xml"});
         BeanFactory factory=context;
         IService serviceImplA=(IService)factory.getBean("serviceImpl");
         serviceImplA.service("Cuiyw ServiceA"); 
         
         System.out.println("-----------------------------------");
         
         ServiceImpl serviceImplA2=factory.getBean("serviceImpl",ServiceImpl.class);
         serviceImplA2.service("Cuiyw ServiceA"); 
    }
    
    /*
     * 生命周期-动态代理
     * */
    public static void proxyText()
    {
//    	MyProxy proxy=new MyProxy();
//    	IFunc func=(IFunc)proxy.bind(new Func());
//    	func.Add(10, 20);
//    	func.sub(5, 1);
    	
    	
    	MyProxySuper proxy=new MyProxySuper();
    	IFunc func=(IFunc)proxy.bind(new Func(),new Console2Log());
    	func.Add(10, 20);
    	func.sub(5, 1);
    	
    }
    
    /*
     * bean的生命周期
     * */
    public static void LiftCycle()
    {
    	System.out.println("1--加载xml文件");
    	ApplicationContext context=new FileSystemXmlApplicationContext("E:\\SVN\\Java\\trunk\\SpringAop\\src\\xml\\ApplicationContext.xml");
    	System.out.println("2--加载完xml文件");
        BeanFactory factory=context;
        System.out.println("3--BeanFactory factory=context");
        LifeCycle lifeCycle=factory.getBean("lifeCycle",LifeCycle.class);
        System.out.println("4--实例化bean");
        lifeCycle.setName("cuiyw2");
         System.out.println("lifeCycle.name="+lifeCycle.getName());
        ((ClassPathXmlApplicationContext)factory).registerShutdownHook();
    }
    
    /*
     * Bean学习
     * */
    public static void testBean()
    {
    	String path=System.getProperty("user.dir");
        System.out.println(path);
        ApplicationContext context=new FileSystemXmlApplicationContext("F:\\Java\\SpringAop\\src\\xml\\ApplicationContext.xml");
        //ApplicationContext context=new ClassPathXmlApplicationContext(new String[]{"ApplicationContext.xml"});
        BeanFactory factory=context;
        IService service=(IService)factory.getBean("ServiceImpl");
        service.service("Cuiyw"); 
        
        IService s1=(IService)factory.getBean("A");
        s1.service("s1");
    }
}
