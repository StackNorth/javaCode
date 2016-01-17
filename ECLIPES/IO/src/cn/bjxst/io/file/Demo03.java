package cn.bjxst.io.file;

import java.io.File;
import java.io.IOException;
/**
 * 常用方法
 * 1、文件名
 * getName()文件名、路径名
 * getPath()路径名
 * getAbsoluteFile()绝对路径所对应的File对象
 * getAbsolutePath()绝对路径名
 * getParent（）父目录，相对路径的父目录，可能为null	
 * 2、判断信息：
 * exists()
 * canWrite()
 * canRead()
 * isFile()
 * isDirectory()
 * isAbsolute()消除平台差异，ie以盘符开头，其他的/开头
 * @author llf
 *3、长度length（）字节数，只能读取文件的长度
 *4、创建、删除
 *creatNewFile()不存在创建新文件，存在返回false
 *delete（）删除文件
 *static creatTempFile；（前缀3个字节长，后缀默认.temp）默认临时空间
 *staticcreatTempFile（前缀3个字节长，后缀默认.temp，目录）
 *deleteOnExit()退出虚拟机删除，常用于删除临时文件 
 */
public class Demo03 {
	
	public static void main(String[] args) {
		try {
			test03();
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("文件操作失败");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
	//创建删除文件
	public static void test03() throws IOException, InterruptedException{
		//creatNewFile()不存在创建新文件
		String path="E:/2.txt";
		//String path="E:/con";//con为系统关键字
		File src= new File(path);
		if(!src.exists()){
			boolean flag= src.createNewFile();//创建新的文件
			System.out.println(flag?"成功":"失败");
		}
		
		//删除文件
		boolean flag=src.delete();
		System.out.println(flag?"成功":"失败");
		
		File temp = src.createTempFile("tex", ".temp",new File("E:"));
		Thread.sleep(1000);
		temp.deleteOnExit();//退出即删除
		
		
	
	}
	//2、判断信息
	public static void test02(){
		String path="E:/2.txt";
		//String path="E:/game";
		//String path="2.txt";
		File src =new File(path);
		//是否存在
		System.out.println("文件是否存在"+src.exists());
		//是否可读写，canWrite() canRead();
		System.out.println("文件是否可读写"+src.canWrite()+src.canRead());
		
		// isFile()
		//isDirectory()
		if(src.isFile()){
			System.out.println("文件");
		}else if(src.isDirectory()){
			System.out.println("文件夹");
		}else{
			System.out.println("文件不存在");
			
		}
		//isAbsolute()判断是否为绝对路径
		System.out.println("是否为绝对路径"+src.isAbsolute());
		System.out.println("长度为："+src.length());
	}
	
	
	//1名称
	public static void test01(){
		File src = new File("E:/xp/test/test.txt");
		//建立联系
		System.out.println(src.getName());//返回名称
		System.out.println(src.getPath());//如果是绝对路径，返回完整路径，否则相对路径
		System.out.println(src.getAbsolutePath());//返回绝对路径
		System.out.println(src.getParent());//返回上级目录，	如果没有上一级，返回空
	}
}
