package cn.bjxst.io.file;

import java.io.File;

/**
 * ���·�������·������file����
 * @author llf
 *
 */
public class Demo02 {
	public static void main(String[] args) {
		String parentpath="E:/xp/test";
		String name="test.txt";
		//���·��
		File src = new File(parentpath,name);
		src= new File(new File(parentpath),name);
		//���
		System.out.println(src.getName());
		System.out.println(src.getPath());
		//����·��
		src = new File("E:/xp/test/test.txt");
		System.out.println(src.getName());
		System.out.println(src.getPath());
		//û���̷���һuser��dir����
		src = new File("test.txt");
		System.out.println(src.getName());
		System.out.println(src.getPath());
		System.out.println(src.getAbsolutePath());
	
	}
}
