package cn.bjxst.io.file;

import java.io.File;
import java.util.Arrays;

/**
 * ����Ӽ�Ŀ¼������
 * 1��listfile'
 * 2���ݹ�
 * @author llf
 *
 */
public class Demo05 {
	public static void main(String[] args) {
		
		String path="E:/Java";
		File src=new File(path);
		//test(src);
		File[] roots=File.listRoots();
		System.out.println(Arrays.toString(roots));
	}
	public static void test(File src){
		if(src==null&&!src.exists())
			return ;
		System.out.println(src.getAbsolutePath());
		if(src.isDirectory()){
		for(File temp:src.listFiles()){
			test(temp);
			}
		}
		
	}
	
	
}