package cn.bjsxt.testFile;

import java.io.File;

public class TestTree {
	public static void main(String[] args){
		File f = new File("d:/Java");
		printFile(f,0);
		
	}
	static void printFile(File file, int level){
		for(int i = 0;i < level;i++){
			System.out.print("-");
		}
		System.out.println(file.getName());
		
		if(file.isDirectory()){
			File[] files = file.listFiles();
			for(File temp : files){
				printFile(temp,level+1);
			}
		}
	}
}
