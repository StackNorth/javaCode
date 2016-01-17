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
	 * �������ͻ���+String������
	 * ��������DataInputStream 
	 * �������DataOutputStream
	 * @author llf
	 * @throws IOException 
	 *
	 */
		public static void main(String[] args) throws IOException {
			byte[] dest=write();
			read(dest);
		}
		/**
		 * ���ļ����ȡ����+����
		 * @throws IOException 
		 */
		public static void read(byte[]  src) throws IOException{
			//����Դ
			DataInputStream dis= new DataInputStream(
						new BufferedInputStream(new ByteArrayInputStream(src))
					);
			
			//������ȡ��˳����д��һ�£�������ڲ��ܶ�ȡ
			//��һ�£����ݴ�������
				double num1=dis.readDouble();
				long num2=dis.readLong();
				String str=dis.readUTF();
				System.out.println(str);
			  
		}
		
		
		/**
		 * ����+����������ֽ�������
		 * @param destPath
		 * @throws IOException
		 */
		public static byte[] write() throws IOException{
			byte[] dest=null ;
			double point=2.5;
			long num=100L;
			String str="��������";
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

