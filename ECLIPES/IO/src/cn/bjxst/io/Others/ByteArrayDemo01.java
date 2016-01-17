package cn.bjxst.io.Others;

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class ByteArrayDemo01 {
	public static void main(String[] args) throws IOException {
		read(writer());
	}
	/**
	 * 输出流操作与文件输出流有些不同，有新增方法，不能使用多态
	 * @throws IOException 
	 */
	public static byte[] writer() throws IOException{
		byte[] dest;
		//选择流不同点
		ByteArrayOutputStream boe =new ByteArrayOutputStream();
		//写出
		String msg="输入流操作与文件输入流操作一致";
		byte[] info=msg.getBytes();
		boe.write(info,0,info.length);
		dest=boe.toByteArray();
		boe.close();
		return dest;
	}
	
	/**
	 * 输入流操作与文件输入流操作一致
	 * @throws IOException 
	 */
	public static void read(byte[] src ) throws IOException{
		
		//选择流
		InputStream is=new BufferedInputStream(
				new ByteArrayInputStream(src)
				);
	//操作
		byte[] flush=new byte[1024];
		int len=0;
		while(-1!=(len=is.read(flush))){
			System.out.println(new String(flush,0,len));
			
		}
		//释放资源
		is.close();
	
	
	}
}
