package cn.bjxst.io.file;

import java.io.File;

/**
 * 两个常量
 * 1路径分隔符;
 * 2名称分隔符\(windows)/(非windows)
 * 
 * @author llf
 *
 */
public class Demo01 {
	public static void main(String[] args) {
		System.out.println(File.pathSeparator);
		System.out.println(File.separator);
		//路径表示形式
		String path="E:\\java\\高琪";//不推荐
		path ="E"+File.separator+"java"+File.separator+"高琪";//不推荐
		path="E:/java/高琪";//推荐使用
	}
}
