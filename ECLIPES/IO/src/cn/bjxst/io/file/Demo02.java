package cn.bjxst.io.file;

import java.io.File;

/**
 * 相对路径与绝对路径构造file对象
 * @author llf
 *
 */
public class Demo02 {
	public static void main(String[] args) {
		String parentpath="E:/xp/test";
		String name="test.txt";
		//相对路径
		File src = new File(parentpath,name);
		src= new File(new File(parentpath),name);
		//输出
		System.out.println(src.getName());
		System.out.println(src.getPath());
		//绝对路径
		src = new File("E:/xp/test/test.txt");
		System.out.println(src.getName());
		System.out.println(src.getPath());
		//没有盘符，一user。dir构建
		src = new File("test.txt");
		System.out.println(src.getName());
		System.out.println(src.getPath());
		System.out.println(src.getAbsolutePath());
	
	}
}
