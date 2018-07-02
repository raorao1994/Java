import java.net.*;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CharsetEncoder;
import java.io.*;
public class TCPClient {

	public static void main(String[] args) throws IOException {
		// TODO 自动生成的方法存根
		Client();
		//Server();
	}

	//客戶端
	public static void Client() throws IOException
	{
		Socket socket=null;
		BufferedReader br=null;
		PrintWriter pw=null;
		BufferedReader brTemp=null;
		try
		{
			socket =new Socket(InetAddress.getLocalHost(),5678);
			br=new BufferedReader(new InputStreamReader(socket.getInputStream()));
			brTemp=new BufferedReader(new InputStreamReader(System.in));
			pw=new PrintWriter(socket.getOutputStream());
			while(true)
			{
				System.out.println("--------------开始---------------");
				String line=brTemp.readLine();
				pw.println(line);
				pw.flush();
				if(line.equals("exit"))break;
				System.out.println("服務器接收的信息："+br.readLine());
				System.out.println("--------------结束---------------");
			}
		}
		catch(Exception ex)
		{
			System.err.println(ex.getMessage());
		}
		finally
		{
			System.err.println("程序關閉");
			if (socket != null) socket.close();
			if (br != null) br.close();
			if (brTemp != null) brTemp.close();
			if (pw != null) pw.close();
		}
	}
	
	//服務端
	public static void Server() throws IOException
    {
        ServerSocket server = null;
        Socket client = null;
        BufferedReader br = null;
        PrintWriter pw = null;
        try
        {
            server = new ServerSocket(5678);
            System.out.println("服務開啟");
            client = server.accept();
            System.out.println("鏈接客戶端");
            br = new BufferedReader(new InputStreamReader(client.getInputStream()));
            pw = new PrintWriter(client.getOutputStream());
            while(true)
            {
                String line = br.readLine();
                System.out.println("收到數據："+line);
                pw.println("Response:" + line);
                pw.flush();
                System.out.println("發送數據："+line);
                if (line.equals("end")) break;
            }
        }
        catch(Exception ex)
        {
            System.err.println(ex.getMessage());
        }
        finally
        {
            if (server != null) server.close();
            if (client != null) client.close();
            if (br != null) br.close();
            if (pw != null) pw.close();
            System.out.println("關閉程序");
        }
    }
	
	//多线程版本的TCP服务器端
	public static void Servers() throws IOException
    {
        ServerSocket server = new ServerSocket(5678);
        while(true)
        {
            Socket client = server.accept();
            Thread thread = new ServerThread(client);
            thread.start();
        }
    }
	
	//UDP通信客户端
	public static void UDPClient()
	{
		try
        {
            InetAddress host = InetAddress.getLocalHost();
            int port = 5678;
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            while(true)
            {
                String line = br.readLine();
                byte[] message = line.getBytes();
                DatagramPacket packet = new DatagramPacket(message, message.length, host, port);
                DatagramSocket socket = new DatagramSocket();
                socket.send(packet);
                socket.close();
                if (line.equals("end")) break;
            }
            br.close();
        }
        catch(Exception ex)
        {
            System.err.println(ex.getMessage());
        }
	}

	//UDP通信服务器端
	public static void UDPServer()
	{
		try
        {
            int port = 5678;
            DatagramSocket dsSocket = new DatagramSocket(port);
            byte[] buffer = new byte[1024];
            DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
            while(true)
            {
                dsSocket.receive(packet);
                String message = new String(buffer, 0, packet.getLength());
                System.out.println(packet.getAddress().getHostName() + ":" + message);
                if (message.equals("end")) break;
                packet.setLength(buffer.length);
            }
            dsSocket.close();
        }
        catch(Exception ex)
        {
            System.err.println(ex.getMessage());
        }
	}

	//多播通信客户端
	public static void DBClient()
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try
        {
            InetAddress address = InetAddress.getByName("230.0.0.1");
            int port = 5678;
            while(true)
            {
                String line = br.readLine();
                byte[] message = line.getBytes();
                DatagramPacket packet = new DatagramPacket(message, message.length, address, port);
                MulticastSocket multicastSocket = new MulticastSocket();
                multicastSocket.send(packet);
                if (line.equals("end")) break;
            }
            br.close();
        }
        catch(Exception ex)
        {
            System.err.println(ex.getMessage());
        }
	}


	//多播通信服务端
	public static void DBServer()
	{
		 int port = 5678;
	        try
	        {
	            MulticastSocket multicastSocket = new MulticastSocket(port);
	            InetAddress address = InetAddress.getByName("230.0.0.1");
	            multicastSocket.joinGroup(address);
	            byte[] buffer = new byte[1024];
	            DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
	            while(true)
	            {
	                multicastSocket.receive(packet);
	                String message = new String(buffer, packet.getLength());
	                System.out.println(packet.getAddress().getHostName() + ":" + message);
	                if (message.equals("end")) break;
	                packet.setLength(buffer.length);
	            }
	            multicastSocket.close();
	        }
	        catch(Exception ex)
	        {
	            System.err.println(ex.getMessage());
	        }
	}

	//NIO（New IO）
	public static void NIO()
	{
		String host="127.0.0.1";
        int port = 5678;
        SocketChannel channel = null;
        try
        {
            InetSocketAddress address = new InetSocketAddress(host,port);
            Charset charset = Charset.forName("UTF-8");
            CharsetDecoder decoder = charset.newDecoder();
            CharsetEncoder encoder = charset.newEncoder();
            
            ByteBuffer buffer = ByteBuffer.allocate(1024);
            CharBuffer charBuffer = CharBuffer.allocate(1024);
            
            channel = SocketChannel.open();
            channel.connect(address);
            
            String request = "GET / \r\n\r\n";
            channel.write(encoder.encode(CharBuffer.wrap(request)));
            
            while((channel.read(buffer)) != -1)
            {
                buffer.flip();
                decoder.decode(buffer, charBuffer, false);
                charBuffer.flip();
                System.out.println(charBuffer);
                buffer.clear();
                charBuffer.clear();
            }
        }
        catch(Exception ex)
        {
            System.err.println(ex.getMessage());
        }
        finally
        {
            if (channel != null)
                try {
                    channel.close();
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
        }
	}
	
}
