package Spring.Service;

import java.lang.reflect.Method;
import java.util.Date;

import Spring.IService.ILog;

public class ConsoleLog implements ILog{


    public void start(Method method) throws Exception {
        // TODO Auto-generated method stub
        System.out.println(new Date()+" method name:"+method.getName() + " start...");

    }

    public void end(Method method) throws Exception {
        // TODO Auto-generated method stub
        System.out.println(new Date()+" method name:"+ method.getName() + " end...");
    }

}
