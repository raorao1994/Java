package Spring.Service;

import java.beans.PropertyDescriptor;

import org.springframework.beans.BeansException;
import org.springframework.beans.PropertyValues;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessor;

public class MyInstantiationAwareBeanPostProcessor implements InstantiationAwareBeanPostProcessor {
	
	MyInstantiationAwareBeanPostProcessor()
	{
		System.out.println("实例化InstantiationAwareBeanPostProcessor实现类");
	}
	
	/*
	 * bean实例化后
	 * */
	public Object postProcessAfterInitialization(Object bean,String beanName)throws BeansException
	{
		System.out.println("执行MyInstantiationAwareBeanPostProcessor的postProcessAfterInitialization方法");
		System.out.println("-----------------------------------------------------------------------------------------");
		return bean;
	}
	/*
	 * bean实例化前
	 * */
	public Object postProcessBeforeInitialization(Object bean,String beanName)throws BeansException
	{
		System.out.println("执行MyInstantiationAwareBeanPostProcessor的postProcessBeforeInitialization方法");
		return bean;
	}
	
	public boolean postProcessAfterInstantiation(Object bean, String beanName) throws BeansException {
        // TODO Auto-generated method stub
		System.out.println("执行MyInstantiationAwareBeanPostProcessor的postProcessAfterInstantiation方法");
        return true;
    }

    public Object postProcessBeforeInstantiation(Class<?> beanClass, String beanName) throws BeansException {
        // TODO Auto-generated method stub
    	System.out.println("执行MyInstantiationAwareBeanPostProcessor的postProcessBeforeInstantiation方法");
        return null;
    }

    public PropertyValues postProcessPropertyValues(PropertyValues pvs, PropertyDescriptor[] pds, Object bean,
            String beanName) throws BeansException {
        // TODO Auto-generated method stub
    	System.out.println("执行MyInstantiationAwareBeanPostProcessor的postProcessPropertyValues方法");
        return pvs;
    }
	
}
