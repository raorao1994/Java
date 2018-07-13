package Spring.Service;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;

public class MyBeanFactoryPostProcessor implements BeanFactoryPostProcessor  {
	
	MyBeanFactoryPostProcessor(){
		
		System.out.println("实例化BeanFactoryPostProcessor实现类");
	}

	public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
		// TODO 自动生成的方法存根
		System.out.println("执行MyBeanFactoryPostProcessor的postProcessBeanFactory方法");
	}
}
