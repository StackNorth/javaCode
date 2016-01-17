package cn.bjxst.io.byteIO;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/**
 * һ����ȡ�ļ���
1��������ϵ��File����
2��ѡ�������ļ���������InPutStream 

FileInputStream
3��������byte[] car=new byte[1024]+read+��

ȡ��С���
4���ر�

 * @author llf
 *
 */
public class Demo01 {
	
	public static void main(String[] args) {
		File src=new File("E:/Java/test.txt");
		InputStream is=null;
		try {
			 is =new FileInputStream(src);
			// �������϶�ȡ
				byte[] car=new byte[10];
				int len=0;
				while(-1!=(len=is.read(car))){
					String info = new String(car,0,len);
					System.out.println(info);
				}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.out.println("�ļ�������");
		} catch (IOException e1) {
			System.out.println("��ȡ�ļ�ʧ��");
			e1.printStackTrace();
		}finally{
				try {
					if(null != is)
					is.close();
				} catch (IOException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				 }
				
			}
			
		
		}
	}

