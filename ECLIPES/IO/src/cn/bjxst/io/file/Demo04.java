package cn.bjxst.io.file;

import java.io.File;
import java.io.FilenameFilter;

/**
 * ����Ŀ¼��
 * mkdir()����Ŀ¼������ȷ����Ŀ¼���ڣ���������ڴ���ʧ��
 * mkdirs()����Ŀ¼�������Ŀ¼�������ڣ�һͬ����
 * list()�ļ���Ŀ¼���ַ�����ʽ
 * listFiles()
 * static listRoots()��·��
 * @author llf
 *
 */
public class Demo04 {
	public static void main(String[] args) {
		String path="E:/Java";
		File file=new File(path);
	//	System.out.println("�Ƿ񴴽��ɹ�"+file.mkdir());
		String path1="E:/game/mckuai";
		File str=new File(path);
		if(str.isDirectory()){
			System.out.println("===========��Ŀ¼======");
			String strName[]=str.list();
			for(String temp:strName){
			System.out.println(temp);	
			}
			System.out.println("===========��Ŀ¼���ļ�File����======");
			File[] subfile=str.listFiles();
			for(File temp:subfile){
				System.out.println(temp.getAbsolutePath());
			}
			
			System.out.println("===========��Ŀ¼��.dll����======");
			//�������ģʽ
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
