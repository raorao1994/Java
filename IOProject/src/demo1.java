import java.io.*;


public class demo1 {

	public static void main(String[] args) throws IOException {
		// TODO �Զ����ɵķ������
		File file=new File("C:\\Users\\chenxw\\Desktop\\����.txt");
		//byte[] buffer=readFileByFileInputStream(file);
		
		byte[] buffer=readFileByBufferedInputStream(file);
		
		copyFileByFileOutputStream(file);
		//������
		String str=new String(buffer);
		System.out.println(str);
	}
	
	//ʹ��InputStream��ȡ�ļ�
	public static byte[] readFileByFileInputStream(File file) throws IOException
	{
		ByteArrayOutputStream output=new ByteArrayOutputStream();
		FileInputStream fis=null;
		try
		{
			fis=new FileInputStream(file);
			byte[] buffer=new byte[1024];
			int bytesRead=0;
			while((bytesRead=fis.read(buffer,0,buffer.length))!=-1)
			{
				output.write(buffer,0,bytesRead);
			}
		}
		catch(Exception ex)
		{
			System.out.println("Error occurs during reading " + file.getAbsoluteFile());
		}
		finally
		{
			if(fis!=null)
				fis.close();
			if(output!=null)
				output.close();
		}
		return output.toByteArray();
	}
	
	//ʹ��BufferedInputStream��ȡ�ļ�
	public static byte[] readFileByBufferedInputStream(File file) throws IOException
	{
		FileInputStream fis=null;
		BufferedInputStream bis=null;
		ByteArrayOutputStream output=new ByteArrayOutputStream();
		try
		{
			fis=new FileInputStream(file);
			bis=new BufferedInputStream(fis);
			byte[] buffer=new byte[1024];
			int bytesRead=0;
			while((bytesRead=bis.read(buffer,0,buffer.length))!=-1)
			{
				output.write(buffer,0,bytesRead);
			}
		}
		catch(Exception ex)
		{
			System.out.println("Error occurs during reading " + file.getAbsoluteFile());
		}
		finally
		{
			if (fis != null) fis.close();
			if (bis != null) bis.close();
			if (output != null) output.close();
		}
		return output.toByteArray();
	}
	
	//ʹ��OutputStream�����ļ�
	public static void copyFileByFileOutputStream(File file) throws IOException
	{
		FileInputStream fis=null;
		FileOutputStream fos=null;
		try
		{
			fis=new FileInputStream(file);
			fos=new FileOutputStream(file.getName() + "����.txt");
			byte[] buffer=new byte[1024];
			int bytesRead=0;
			while((bytesRead=fis.read(buffer,0,buffer.length))!=-1)
			{
				fos.write(buffer, 0, buffer.length);
			}
			fos.flush();
		}
		catch(Exception ex)
		{
			System.out.println("Error occurs during copying " + file.getAbsoluteFile());
		}
		finally
		{
			if (fis != null) fis.close();
		    if (fos != null) fos.close();
		}
		
	}
	
	//ʹ��BufferedOutputStream�����ļ�
	public static void copyFilebyBufferedOutputStream(File file)throws IOException
	{
	    FileInputStream fis = null;
	    BufferedInputStream bis = null;
	    FileOutputStream fos = null;
	    BufferedOutputStream bos = null;
	    try
	    {
	        fis = new FileInputStream(file);
	        bis = new BufferedInputStream(fis);
	        fos = new FileOutputStream(file.getName() + ".bak");
	        bos = new BufferedOutputStream(fos);
	        byte[] buffer = new byte[1024];
	        int bytesRead = 0;
	        while((bytesRead = bis.read(buffer, 0, buffer.length)) != -1)
	        {
	            bos.write(buffer, 0, bytesRead);
	        }
	        bos.flush();
	    }
	    catch(Exception ex)
	    {
	        System.out.println("Error occurs during copying " + file.getAbsoluteFile());
	    }
	    finally
	    {
	        if (fis != null) fis.close();
	        if (bis != null) bis.close();
	        if (fos != null) fos.close();
	        if (bos != null) bos.close();
	    }
	}

	//ʹ��BufferedReader��ȡ�ļ�����
	public static String readFile(String file)throws IOException
	{
	    BufferedReader br = null;
	    StringBuffer sb = new StringBuffer();
	    try
	    {
	        br = new BufferedReader(new FileReader(file));
	        String line = null;
	        
	        while((line = br.readLine()) != null)
	        {
	            sb.append(line);
	        }
	    }
	    catch(Exception ex)
	    {
	        System.out.println("Error occurs during reading " + file);
	    }
	    finally
	    {
	        if (br != null) br.close();
	    }
	    return sb.toString();
	}

	//ʹ��BufferedWriter�����ļ�
	public static void copyFile(String file) throws IOException
	{ 
	    BufferedReader br = null;
	    BufferedWriter bw = null;
	    try
	    {
	        br = new BufferedReader(new FileReader(file));
	        bw = new BufferedWriter(new FileWriter(file + ".bak"));
	        String line = null;
	        while((line = br.readLine())!= null)
	        {
	            bw.write(line);
	        }
	    }
	    catch(Exception ex)
	    {
	        System.out.println("Error occurs during copying " + file);
	    }
	    finally
	    {
	        if (br != null) br.close();
	        if (bw != null) bw.close();
	    }
	}
	
	//������С�̶����ļ�
	public static void createFile(String file, int size) throws IOException
	{
	    File temp = new File(file);
	    RandomAccessFile raf = new RandomAccessFile(temp, "rw");
	    raf.setLength(size);
	    raf.close();
	}
	
	//���ļ��������������
	public static void writeFile(String file, byte[] content, int startPos, int contentLength) throws IOException
	{
	    RandomAccessFile raf = new RandomAccessFile(new File(file), "rw");
	    raf.seek(startPos);
	    raf.write(content, 0, contentLength);
	    raf.close();
	}
	
	//�ƶ��ļ�
	public static boolean moveFile(String sourceFile, String destFile)
	{
	    File source = new File(sourceFile);
	    if (!source.exists()) throw new RuntimeException("source file does not exist.");
	    File dest = new File(destFile);
	    if (!(new File(dest.getPath()).exists())) new File(dest.getParent()).mkdirs();
	    return source.renameTo(dest);
	}
	
	//�����ļ�
	public static void copyFile(String sourceFile, String destFile) throws IOException
	{
	    File source = new File(sourceFile);
	    if (!source.exists()) throw new RuntimeException("File does not exist.");
	    if (!source.isFile()) throw new RuntimeException("It is not file.");
	    if (!source.canRead()) throw new RuntimeException("File cound not be read.");
	    File dest = new File(destFile);
	    if (dest.exists())
	    {
	        if (dest.isDirectory()) throw new RuntimeException("Destination is a folder.");
	        else
	        {
	            dest.delete();
	        }
	    }
	    else
	    {
	        File parentFolder = new File(dest.getParent());
	        if (!parentFolder.exists()) parentFolder.mkdirs();
	        if (!parentFolder.canWrite()) throw new RuntimeException("Destination can not be written.");
	    }
	    FileInputStream fis = null;
	    FileOutputStream fos = null;
	    try
	    {
	        fis = new FileInputStream(source);
	        fos = new FileOutputStream(dest);
	        byte[] buffer = new byte[1024];
	        int bytesRead = 0;
	        while((bytesRead = fis.read(buffer, 0, buffer.length)) != -1)
	        {
	            fos.write(buffer, 0, bytesRead);
	        }
	        fos.flush();
	    }
	    catch(IOException ex)
	    {
	        System.out.println("Error occurs during copying " + sourceFile);
	    }
	    finally
	    {
	        if (fis != null) fis.close();
	        if (fos != null) fos.close();
	    }
	}
	
	//�����ļ���
	public static void copyDir(String sourceDir, String destDir) throws IOException
	{
	    
	    File source = new File(sourceDir);
	    if (!source.exists()) throw new RuntimeException("Source does not exist.");
	    if (!source.canRead()) throw new RuntimeException("Source could not be read.");
	    File dest = new File(destDir);
	    if (!dest.exists()) dest.mkdirs();
	    
	    File[] arrFiles = source.listFiles();
	    for(int i = 0; i < arrFiles.length; i++)
	    {
	        if (arrFiles[i].isFile())
	        {
	            BufferedReader reader = new BufferedReader(new FileReader(arrFiles[i]));
	            BufferedWriter writer = new BufferedWriter(new FileWriter(destDir + "/" + arrFiles[i].getName()));
	            String line = null;
	            while((line = reader.readLine()) != null) writer.write(line);
	            writer.flush();
	            reader.close();
	            writer.close();
	        }
	        else
	        {
	            copyDir(sourceDir + "/" + arrFiles[i].getName(), destDir + "/" + arrFiles[i].getName());
	        }
	    }
	}
	
	//ɾ���ļ���
	public static void del(String filePath)
	{
	    File file = new File(filePath);
	    if (file == null || !file.exists()) return;
	    if (file.isFile())
	    {
	        file.delete();
	    }
	    else
	    {
	        File[] arrFiles = file.listFiles();
	        if (arrFiles.length > 0)
	        {
	            for(int i = 0; i < arrFiles.length; i++)
	            {
	                del(arrFiles[i].getAbsolutePath());
	            }
	        }
	        file.delete();
	    }
	}
	
	//��ȡ�ļ��д�С
	public static long getFolderSize(String dir)
	{
	    long size = 0;
	    File file = new File(dir);
	    if (!file.exists()) throw new RuntimeException("dir does not exist.");
	    if (file.isFile()) return file.length();
	    else
	    {
	        String[] arrFileName = file.list();
	        for (int i = 0; i < arrFileName.length; i++)
	        {
	            size += getFolderSize(dir + "/" + arrFileName[i]);
	        }
	    }
	    
	    return size;
	}
	
	//�����ļ��зֳɶ��С�ļ�
	public static void splitFile(String filePath, long unit) throws IOException
	{
	    File file = new File(filePath);
	    if (!file.exists()) throw new RuntimeException("file does not exist.");
	    long size = file.length();
	    if (unit >= size) return;
	    int count = size % unit == 0 ? (int)(size/unit) : (int)(size/unit) + 1;
	    String newFile = null;
	    FileOutputStream fos = null;
	    FileInputStream fis =null;
	    byte[] buffer = new byte[(int)unit];
	    fis = new FileInputStream(file);
	    long startPos = 0;
	    String countFile = filePath + "_Count";
	    PrintWriter writer = new PrintWriter(new FileWriter( new File(countFile)));
	    writer.println(filePath + "\t" + size);
	    for (int i = 1; i <= count; i++)
	    {
	        newFile = filePath + "_" + i;
	        startPos = (i - 1) * unit;
	        System.out.println("Creating " + newFile);
	        fos = new FileOutputStream(new File(newFile));
	        int bytesRead = fis.read(buffer, 0, buffer.length);
	        if (bytesRead != -1)
	        {
	            fos.write(buffer, 0, bytesRead);
	            writer.println(newFile + "\t" + startPos + "\t" + bytesRead);
	        }
	        fos.flush();
	        fos.close();
	        System.out.println("StartPos:" + i*unit + "; EndPos:" + (i*unit + bytesRead));
	    }
	    writer.flush();
	    writer.close();
	    fis.close();
	}
	
	//�����С�ļ��ϲ���һ�����ļ�
	public static void linkFiles(String countFile) throws IOException
	{
	    File file = new File(countFile);
	    if (!file.exists()) throw new RuntimeException("Count file does not exist.");
	    BufferedReader reader = new BufferedReader(new FileReader(file));
	    String line = reader.readLine();
	    String newFile = line.split("\t")[0];
	    long size = Long.parseLong(line.split("\t")[1]);
	    RandomAccessFile raf = new RandomAccessFile(newFile, "rw");
	    raf.setLength(size);
	    FileInputStream fis = null;
	    byte[] buffer = null;
	    
	    while((line = reader.readLine()) != null)
	    {
	        String[] arrInfo = line.split("\t");
	        fis = new FileInputStream(new File(arrInfo[0]));
	        buffer = new byte[Integer.parseInt(arrInfo[2])];
	        long startPos = Long.parseLong(arrInfo[1]);
	        fis.read(buffer, 0, Integer.parseInt(arrInfo[2]));
	        raf.seek(startPos);
	        raf.write(buffer, 0, Integer.parseInt(arrInfo[2]));
	        fis.close();
	    }
	    raf.close();
	}
	
	//ִ���ⲿ����
	public static void execExternalCommand(String command, String argument)
	{
	    Process process = null;
	    try
	    {
	        process = Runtime.getRuntime().exec(command + " " + argument);
	        InputStream is = process.getInputStream();
	        BufferedReader br = new BufferedReader(new InputStreamReader(is));
	        String line = null;
	        while((line = br.readLine()) != null)
	        {
	            System.out.println(line);
	        }
	    }
	    catch(Exception ex)
	    {
	        System.err.println(ex.getMessage());
	    }
	    finally
	    {
	        if (process != null) process.destroy();
	    }
	}
}
