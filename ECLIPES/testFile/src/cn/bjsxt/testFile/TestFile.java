package cn.bjsxt.testFile;

import java.io.File;
import java.io.IOException;

public class TestFile {
	public static void main(String[] args){
		File f = new File("C:/Users/llf/Desktop/�ʼ�/java�ʼ�01.txt");
		File f2 = new File("C:/Users/llf/Desktop/�ʼ�");
		File f3 = new File(f2,"C:/Users/llf/Desktop/�ʼ�/java�ʼ�01");
		File f4 = new File(f2,"java�ʼ�");
		try {
			f4.createNewFile();
		} catch (IOException e) {
			e.printStackTrace();
		}
		if(f.isFile()){
			System.out.println("��һ���ļ�");
		}
		if(f2.isDirectory()){
			System.out.println("��һ��Ŀ¼");
		}
		
	}
}
