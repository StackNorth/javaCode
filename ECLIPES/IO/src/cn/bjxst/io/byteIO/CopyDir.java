package cn.bjxst.io.byteIO;

import java.io.File;
import java.io.IOException;

/**
 * �ļ��Ŀ���
 * 1�ļ���ֵ copyFile
 * �ļ�����mkdirs()
 * 3���ݹ�������Ｖ
 *
 */
public class CopyDir {
	public static void main(String[] args) {
		String srcpath="E:/Java";
		String destpath="E:/dir";
		FileUtil.copyDir(srcpath,destpath);
	}
	
	
}
