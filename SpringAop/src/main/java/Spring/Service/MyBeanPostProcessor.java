package Spring.Service;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

public class MyBeanPostProcessor implements BeanPostProcessor  {
	
	MyBeanPostProcessor(){
		System.out.println("创建BeanPostProcessor实现类");
	}
	
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        // TODO Auto-generated method stub
        System.out.println("执行MyBeanPostProcessor的postProcessAfterInitialization方法");
        return bean;
    }

    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        // TODO Auto-generated method stub
    	System.out.println("执行MyBeanPostProcessor的postProcessBeforeInitialization方法");
        return bean;
    }
}
