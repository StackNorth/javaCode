package cn.bjxst.io.file;

import java.io.File;
import java.io.FilenameFilter;

/**
 * 操作目录，
 * mkdir()创建目录，必须确保父目录存在，如果不存在创建失败
 * mkdirs()创建目录，如果父目录链不存在，一同创建
 * list()文件；目录名字符串形式
 * listFiles()
 * static listRoots()根路径
 * @author llf
 *
 */
public class Demo04 {
	public static void main(String[] args) {
		String path="E:/Java";
		File file=new File(path);
	//	System.out.println("是否创建成功"+file.mkdir());
		String path1="E:/game/mckuai";
		File str=new File(path);
		if(str.isDirectory()){
			System.out.println("===========子目录======");
			String strName[]=str.list();
			for(String temp:strName){
			System.out.println(temp);	
			}
			System.out.println("===========子目录：文件File对象======");
			File[] subfile=str.listFiles();
			for(File temp:subfile){
				System.out.println(temp.getAbsolutePath());
			}
			
			System.out.println("===========子目录：.dll对象======");
			//命令设计模式
			 subfile=str.listFiles(new FilenameFilter(){

				@Override
				public boolean accept(File dir, String name) {
					//System.out.println(dir.getAbsolutePath());
					return new File(dir,name).isFile()&&name.endsWith(".dll");
				}});
			 for(File temp:subfile){
					System.out.println(temp.getAbsolutePath());
				}
				
			 
		}
	}
}
