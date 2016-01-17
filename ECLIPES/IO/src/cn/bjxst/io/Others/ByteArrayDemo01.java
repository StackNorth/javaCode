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
	 * ������������ļ��������Щ��ͬ������������������ʹ�ö�̬
	 * @throws IOException 
	 */
	public static byte[] writer() throws IOException{
		byte[] dest;
		//ѡ������ͬ��
		ByteArrayOutputStream boe =new ByteArrayOutputStream();
		//д��
		String msg="�������������ļ�����������һ��";
		byte[] info=msg.getBytes();
		boe.write(info,0,info.length);
		dest=boe.toByteArray();
		boe.close();
		return dest;
	}
	
	/**
	 * �������������ļ�����������һ��
	 * @throws IOException 
	 */
	public static void read(byte[] src ) throws IOException{
		
		//ѡ����
		InputStream is=new BufferedInputStream(
				new ByteArrayInputStream(src)
				);
	//����
		byte[] flush=new byte[1024];
		int len=0;
		while(-1!=(len=is.read(flush))){
			System.out.println(new String(flush,0,len));
			
		}
		//�ͷ���Դ
		is.close();
	
	
	}
}
