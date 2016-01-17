package cn.bjxst.io.Others;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * 
 * @author llf
 *
 */
public class ByteArrayDemo02 {
	public static void main(String[] args) throws IOException {
		byte[] data=getByteArrayFromFile("E:/Java/abc.txt");
		toFileFromBytArray(data,"E:/Java/abcd.txt");
	}
	public static byte[] getByteArrayFromFile(String srcPath) throws IOException{
		//�ļ�--����--�ֽ�����
		
		//�����ļ�Դ
		File src= new File(srcPath);
		//�����ֽ�����
		byte[] dest=null;
		//ѡ����
		//�ļ�������
		InputStream is=new BufferedInputStream(new FileInputStream(src));
		//�ֽ����������������ʹ�ö�̬
		ByteArrayOutputStream bos=new ByteArrayOutputStream();
		//���� ���϶�ȡ�ļ�д���� 
		int len=0;
		byte[] flush= new byte[1024];
		while(-1!=(len=is.read(flush))){
			bos.write(flush,0,len);
			
		}
		bos.flush();
		dest=bos.toByteArray();
		bos.close();
		is.close();
		
		return dest;
		
	}
	//�ֽ�����--����--�ļ�
	public static void toFileFromBytArray(byte[] src,String destPath) throws IOException{
		File dest= new File(destPath);
		InputStream is=new BufferedInputStream(new ByteArrayInputStream(src));
		OutputStream os=new BufferedOutputStream(new FileOutputStream(dest));
		int len=0;
		byte[] flush= new byte[1024];
		while(-1!=(len=is.read(flush))){
			os.write(flush,0,len);
			
		}
		os.flush();
		os.close();
		is.close();
	}
}
