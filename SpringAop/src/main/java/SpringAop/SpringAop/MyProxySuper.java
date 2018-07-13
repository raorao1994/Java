package SpringAop.SpringAop;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class MyProxySuper implements InvocationHandler {
	//调用对象
    private Object proxy;
    //目标对象
    private Object target;
    
    public Object bind(Object object,Object proxy){
        this.target = object;
        this.proxy=proxy;
        return Proxy.newProxyInstance(this.target.getClass().getClassLoader(), this.target.getClass().getInterfaces(), this);
    }
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object result = null;
        
        //反射得到操作者的实例
        Class<? extends Object> clazz = this.proxy.getClass();
        //反射得到操作者的Start方法
        Method start =clazz.getDeclaredMethod("start",new Class[]{Method.class});
        //反射执行start方法
        start.invoke(this.proxy, new Object[]{method});
        //执行要处理对象的原本方法
        result=method.invoke(this.target, args);
        //反射得到操作者的end方法
        Method end = clazz.getDeclaredMethod("end", new Class[]{Method.class});
        //反射执行end方法
        end.invoke(this.proxy, new Object[]{method});
        return result;
    }
}
