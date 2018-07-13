package Spring.IService;

import java.lang.reflect.Method;

/*
 * log接口
 * */
public interface ILog {
	public void start(Method method) throws Exception;
    public void end(Method method) throws Exception;
}
