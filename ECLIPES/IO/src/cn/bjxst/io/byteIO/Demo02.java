package cn.bjxst.io.byteIO;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class Demo02 {
	public static void main(String[] args) {
		//�����ļ���ϵ
	File str=new File("E:/Java/test.txt");
	OutputStream os =null;
	try {
		//��׷����ʽд���ļ�����Ϊtrue������Ϊfalse
		os= new FileOutputStream(str,true);
		String src="bjsxt is very good!";
		//�ַ�תת��Ϊ����
		byte[] data=src.getBytes();
		//д��
		os.write(data,0,data.length);
		System.out.println("�ļ��ɹ�д��");
		//ǿ��ˢ�³�ȥ������ϰ��
		os.flush();
	} catch (FileNotFoundException e) {
		System.out.println("�ļ�δ�ҵ�");
		e.printStackTrace();
	} catch (IOException e1) {
		System.out.println("�ļ�д��ʧ��");
		e1.printStackTrace();
	}finally{
		if(null != os)
			try {
				os.close();
			} catch (IOException e) {
				System.out.println("�ļ��ر��쳣");
				e.printStackTrace();
			}
		
	}
	
  }
}
