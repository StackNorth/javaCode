package cn.bjsxt.test;

import java.io.*;


public class TestReadFile {
	
	public static void main(String[] args){
		FileReader reader = null;
		try{
		reader = new FileReader("d:/a.txt");
		char c = (char)reader.read();
		char c2 = (char)reader.read();
		System.out.println("¶Á³öµÄÄÚÈÝ:" + c + c2);
		}catch(FileNotFoundException e){
			System.out.println("no fond file");
			e.printStackTrace();
		}catch(IOException e){
			System.out.println("file read error!");
		}finally{
			System.out.println("it can be carry out! ");
			try{
				if(reader != null){
					reader.close();
				}
				
			}catch(IOException e){
				e.printStackTrace();
			}
		}
	}
}	