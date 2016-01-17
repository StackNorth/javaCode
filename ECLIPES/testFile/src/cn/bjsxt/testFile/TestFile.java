package cn.bjsxt.testFile;

import java.io.File;
import java.io.IOException;

public class TestFile {
	public static void main(String[] args){
		File f = new File("C:/Users/llf/Desktop/笔记/java笔记01.txt");
		File f2 = new File("C:/Users/llf/Desktop/笔记");
		File f3 = new File(f2,"C:/Users/llf/Desktop/笔记/java笔记01");
		File f4 = new File(f2,"java笔记");
		try {
			f4.createNewFile();
		} catch (IOException e) {
			e.printStackTrace();
		}
		if(f.isFile()){
			System.out.println("是一个文件");
		}
		if(f2.isDirectory()){
			System.out.println("是一个目录");
		}
		
	}
}
