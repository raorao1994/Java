package Spring.Service;

import java.lang.reflect.Method;

import Spring.IService.ILog;

public class Console2Log implements ILog {

	public void start(Method method) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("Console2Log前执行");
	}

	public void end(Method method) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("Console2Log前执后");
	}

}
