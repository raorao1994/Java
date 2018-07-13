package SpringAop.SpringAop;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class MyProxy implements InvocationHandler {
	
	private Object traget;//目标对象
	
	 public Object bind(Object tar)
	    {
	        this.traget = tar;
	        //绑定该类实现的所有接口，取得代理类
	        return Proxy.newProxyInstance(this.traget.getClass().getClassLoader(), this.traget.getClass().getInterfaces(), this);
	    }  
	
	
	public Object invoke(Object arg0, Method arg1, Object[] arg2) throws Throwable {//不依赖具体接口实现
		// TODO 自动生成的方法存根
		
		Object result=null;//返回值
		
		System.out.println("执行方法前");
		
		result=arg1.invoke(traget, arg2);
		
		System.out.println("执行方法后");
		
		return result;
	}

}
