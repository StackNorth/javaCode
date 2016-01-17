package cn.bjxst.io.Others;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileDescriptor;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

/**
 * 三个常量
 * System.in输入流键盘输入
 * System.out输出流 控制台输出
 * System.err
 * @author llf
 *==>重定向
 *FileDescriptor.in标准输出流
 *FileDescriptor.out
 *FileDescriptor.err
 *setIn()
 *setOut()
 *setErr()
 */
public class SystemDemo01 {
	public static void main(String[] args) throws FileNotFoundException {
		//test();
		System.setOut(new PrintStream(new BufferedOutputStream(new FileOutputStream("e:/Java/print.txt")),true));//需要自动刷新(flush)
		System.out.println("a");//控制台-->文件
		System.setOut(new PrintStream(new BufferedOutputStream(new FileOutputStream(FileDescriptor.out)),true));//文件-->控制台
		System.out.println("a");
	}
	public static void test01() throws FileNotFoundException{
		InputStream is=System.in;
		is= new BufferedInputStream(new FileInputStream("E:/Java/print.txt"));
		Scanner sc=new Scanner(is);
		System.out.println("enter input:");
		System.out.println(sc.nextLine());
		
	}
	public static void test(){
		System.out.println("test");
		System.err.println("err");
		
	}
}