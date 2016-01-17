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
 * �������ͻ���+String������
 * ��������DataInputStream 
 * �������DataOutputStream
 * @author llf
 *
 */
public class DataDemo01 {
	public static void main(String[] args) throws IOException {
		//write("E:/Java/123.txt");
		//	read("E:/Java/1234.txt");�������ļ����Ƿ���
		read("E:/Java/123.txt");
	}
	/**
	 * ���ļ����ȡ����+����
	 * @throws IOException 
	 */
	public static void read(String destPath) throws IOException{
		//����Դ
		File src=new File(destPath);
		DataInputStream dis= new DataInputStream(
					new BufferedInputStream(new FileInputStream(src))
				);
		
		//������ȡ��˳����д��һ�£�������ڲ��ܶ�ȡ
		//��һ�£����ݴ�������
			double num1=dis.readDouble();
			long num2=dis.readLong();
			String str=dis.readUTF();
			System.out.println(str);
			dis.close();
	}
	
	
	/**
	 * ���ݼ�����������ļ�
	 * @param destPath
	 * @throws IOException
	 */
	public static void write(String destPath) throws IOException{
		double point=2.5;
		long num=100L;
		String str="��������";
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
