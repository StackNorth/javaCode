package cn.bjxst.io.Others;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class DataDemo02 {
	/**
	 * 数据类型基本+String处理流
	 * 输入流：DataInputStream 
	 * 输出流：DataOutputStream
	 * @author llf
	 * @throws IOException 
	 *
	 */
		public static void main(String[] args) throws IOException {
			byte[] dest=write();
			read(dest);
		}
		/**
		 * 从文件冲读取数据+类型
		 * @throws IOException 
		 */
		public static void read(byte[]  src) throws IOException{
			//创建源
			DataInputStream dis= new DataInputStream(
						new BufferedInputStream(new ByteArrayInputStream(src))
					);
			
			//操作读取的顺序与写出一致，必须存在才能读取
			//不一致，数据存在问题
				double num1=dis.readDouble();
				long num2=dis.readLong();
				String str=dis.readUTF();
				System.out.println(str);
			  
		}
		
		
		/**
		 * 数据+类型输出到字节数组中
		 * @param destPath
		 * @throws IOException
		 */
		public static byte[] write() throws IOException{
			byte[] dest=null ;
			double point=2.5;
			long num=100L;
			String str="数据类型";
			ByteArrayOutputStream bos= new ByteArrayOutputStream();
			DataOutputStream dos=new DataOutputStream(
					new BufferedOutputStream(bos));
			dos.writeDouble(point);
			dos.writeLong(num);
			dos.writeUTF(str);
			dos.flush();
			dest = bos.toByteArray(); 
			dos.close();
			bos.close();
			return dest;
		}
}

