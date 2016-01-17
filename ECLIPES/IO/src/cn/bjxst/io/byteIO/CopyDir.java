package cn.bjxst.io.byteIO;

import java.io.File;
import java.io.IOException;

/**
 * 文件的拷贝
 * 1文件赋值 copyFile
 * 文件创建mkdirs()
 * 3、递归查找子孙级
 *
 */
public class CopyDir {
	public static void main(String[] args) {
		String srcpath="E:/Java";
		String destpath="E:/dir";
		FileUtil.copyDir(srcpath,destpath);
	}
	
	
}
