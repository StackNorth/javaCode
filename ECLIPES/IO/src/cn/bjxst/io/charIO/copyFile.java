package cn.bjxst.io.charIO;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;

public class copyFile {
	public static void main(String[] args) {
		//����Դ�������ַ��Ĵ��ı�
				File src= new File("D:/java/Dog.java");
				File dest=new File("E:/Java/abc.txt"); 
				//ѡ����
				Writer wr=null;
				Reader reader=null;
				try {
					reader =new FileReader(src);
					wr=new FileWriter(dest);
					char[] flush=new char[1024];
					int len=0;
						while(-1!=(len=reader.read(flush))){
							wr.write(flush,0,len);
						}
						wr.flush();
				} catch (FileNotFoundException e) {
					e.printStackTrace();
					System.out.println("Դ�ļ�������");
				}catch (IOException e) {
					System.out.println("�ļ���ȡʧ��");
					e.printStackTrace();
				}finally{
					
						try {
							if(null==wr){
							wr.close();
							}
						} catch (IOException e) {
							e.printStackTrace();
						}
					}
					if(null!=reader){
						try {
							reader.close();
						} catch (IOException e2) {
							e2.printStackTrace();
						}
						
					}
					
				}
					
				
				
}
