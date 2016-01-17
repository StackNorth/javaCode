package cn.bjxst.io.charIO;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

/**
 * ���ı���ȡ
 * @author llf
 *
 */
public class Demo01 {
	public static void main(String[] args) {
		//����Դ
		File src= new File("D:/java/Dog.java");
		//ѡ����
		Reader reader=null;
		try {
			reader =new FileReader(src);
			char[] flush=new char[1024];
			int len=0;
				while(-1!=(len=reader.read(flush))){
					String str=new String(flush,0,len);
					System.out.println(str);
				}
					
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.out.println("Դ�ļ�������");
		}catch (IOException e) {
			System.out.println("�ļ���ȡʧ��");
			e.printStackTrace();
		}finally{
			if(null!=reader){
				try {
					reader.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
				
			}
			
		}
			
	}
}
