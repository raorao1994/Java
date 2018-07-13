package Spring.Service;

import Spring.Dao.DaoImpl;

public class IOCFactory {

    public static final DaoImpl getStaticFactoryDaoImpl(){ 
        return new DaoImpl(); 
    }
    
    public  final DaoImpl getInstanceFactoryDaoImpl(){ 
        return new DaoImpl(); 
    }
}