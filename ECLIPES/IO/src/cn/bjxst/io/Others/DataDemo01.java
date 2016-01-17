package cn.bjxst.io.Others;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 数据类型基本+String处理流
 * 输入流：DataInputStream 
 * 输出流：DataOutputStream
 * @author llf
 *
 */
public class DataDemo01 {
	public static void main(String[] args) throws IOException {
		//write("E:/Java/123.txt");
		//	read("E:/Java/1234.txt");不存在文件，非法的
		read("E:/Java/123.txt");
	}
	/**
	 * 从文件冲读取数据+类型
	 * @throws IOException 
	 */
	public static void read(String destPath) throws IOException{
		//创建源
		File src=new File(destPath);
		DataInputStream dis= new DataInputStream(
					new BufferedInputStream(new FileInputStream(src))
				);
		
		//操作读取的顺序与写出一致，必须存在才能读取
		//不一致，数据存在问题
			double num1=dis.readDouble();
			long num2=dis.readLong();
			String str=dis.readUTF();
			System.out.println(str);
			dis.close();
	}
	
	
	/**
	 * 数据家类型输出到文件
	 * @param destPath
	 * @throws IOException
	 */
	public static void write(String destPath) throws IOException{
		double point=2.5;
		long num=100L;
		String str="数据类型";
		File src=new File(destPath);
		DataOutputStream dos=new DataOutputStream(
				new BufferedOutputStream(new FileOutputStream(src))
				);
		dos.writeDouble(point);
		dos.writeLong(num);
		dos.writeUTF(str);
		dos.flush();
		dos.close();
	}
}
