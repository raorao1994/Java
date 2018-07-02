import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
/*
 * 多线程版本的TCP服务器端
 * */
public class ServerThread extends Thread 
{
    private Socket socket = null;

    public ServerThread(Socket socket)
    {
        this.socket = socket;
    }
    
    public void run() {
        BufferedReader br = null;
        PrintWriter pw = null;
        try
        {
            br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            pw = new PrintWriter(socket.getOutputStream());
            while(true)
            {
                String line = br.readLine();
                pw.println("Response:" + line);
                pw.flush();
                if (line.equals("end")) break;
            }
        }
        catch(Exception ex)
        {
            System.err.println(ex.getMessage());
        }
        finally
        {
            if (socket != null)
                try {
                    socket.close();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            if (br != null)
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            if (pw != null) pw.close();
        }
    }
}
