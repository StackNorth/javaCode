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
 * ��������
 * System.in��������������
 * System.out����� ����̨���
 * System.err
 * @author llf
 *==>�ض���
 *FileDescriptor.in��׼�����
 *FileDescriptor.out
 *FileDescriptor.err
 *setIn()
 *setOut()
 *setErr()
 */
public class SystemDemo01 {
	public static void main(String[] args) throws FileNotFoundException {
		//test();
		System.setOut(new PrintStream(new BufferedOutputStream(new FileOutputStream("e:/Java/print.txt")),true));//��Ҫ�Զ�ˢ��(flush)
		System.out.println("a");//����̨-->�ļ�
		System.setOut(new PrintStream(new BufferedOutputStream(new FileOutputStream(FileDescriptor.out)),true));//�ļ�-->����̨
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