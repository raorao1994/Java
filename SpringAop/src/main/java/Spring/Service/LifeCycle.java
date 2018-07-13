package Spring.Service;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class LifeCycle implements BeanFactoryAware,BeanNameAware,InitializingBean,DisposableBean,ApplicationContextAware {

	private String name;
    public String getName() {
        System.out.println("getName name="+name);
        return name;
    }
    public void setName(String name) {
         System.out.println("setName name="+name);
        this.name = name;
    }
	
	
	public void setApplicationContext(ApplicationContext arg0) throws BeansException {
		// TODO 自动生成的方法存根
		System.out.println("设置app上下文setApplicationContext");
	}

	public void destroy() throws Exception {
		// TODO 自动生成的方法存根
		System.out.println("销毁bean destroy");
	}

	public void afterPropertiesSet() throws Exception {
		// TODO 自动生成的方法存根
		System.out.println("设置执行后 afterPropertiesSet");
	}

	public void setBeanName(String arg0) {
		// TODO 自动生成的方法存根
		System.out.println("设置bean名称setBeanName");
	}

	public void setBeanFactory(BeanFactory arg0) throws BeansException {
		// TODO 自动生成的方法存根
		System.out.println("设置Bean工厂：setBeanFactory");
	}
	
	  public void myInit() {
	        System.out.println("【init-method】调用<bean>的init-method属性指定的初始化方法");
	    }

	    public void myDestory() {
	        System.out.println("【destroy-method】调用<bean>的destroy-method属性指定的初始化方法");
	    }

}
