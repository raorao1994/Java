import java.net.*;
import java.io.*;
//一个简单的TCP连接池
public class TcpConnectionPool {
	private InetAddress address = null;
    private int port;
    private Socket[] arrSockets = null;
    private boolean[] arrStatus = null;
    private int count;
    
    public TcpConnectionPool(InetAddress address, int port, int count)
    {
        this.address = address;
        this.port = port;
        this .count = count;
        arrSockets = new Socket[count];
        arrStatus = new boolean[count];
        
        init();
    }
    
    private void init()
    {
        try
        {
            for (int i = 0; i < count; i++)
            {
                arrSockets[i] = new Socket(address.getHostAddress(), port);
                arrStatus[i] = false;
            }
        }
        catch(Exception ex)
        {
            System.err.println(ex.getMessage());
        }
    }
    
    public Socket getConnection()
    {
        if (arrSockets == null) init();
        int i = 0;
        for(i = 0; i < count; i++)
        {
            if (arrStatus[i] == false) 
            {
                arrStatus[i] = true;
                break;
            }
        }
        if (i == count) throw new RuntimeException("have no connection availiable for now.");
        
        return arrSockets[i];
    }
    
    public void releaseConnection(Socket socket)
    {
        if (arrSockets == null) init();
        for (int i = 0; i < count; i++)
        {
            if (arrSockets[i] == socket)
            {
                arrStatus[i] = false;
                break;
            }
        }
    }
    
    public void reBuild()
    {
        init();
    }
    
    public void destory()
    {
        if (arrSockets == null) return;
        
        for(int i = 0; i < count; i++)
        {
            try
            {
                arrSockets[i].close();
            }
            catch(Exception ex)
            {
                System.err.println(ex.getMessage());
                continue;
            }
        }
    }
}
