package cn.bjxst.io.Others;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class ObjectDemo01 {
	public static void main(String[] args) {
		String data="E:/Java/ser.txt";	
		try {
			read(data);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void read(String destPath) throws FileNotFoundException, IOException, ClassNotFoundException{
		File src=new File(destPath);
		ObjectInputStream dis= new ObjectInputStream(
					new BufferedInputStream(new FileInputStream(src))
				);
		Object obj=dis.readObject();
		if(obj instanceof Employee){//instanceof指向的对象是否是类的实例
			Employee emp=(Employee)obj;
			System.out.println(emp.getName());
			System.out.println(emp.getSalary());
		}
			dis.close();
		
	}
	
	
	public static void seri(String destPath) throws FileNotFoundException, IOException{
		Employee emp= new Employee("bjxst",10000);
		File dest=new File(destPath);
		ObjectOutputStream dos=new ObjectOutputStream(
				new BufferedOutputStream(new FileOutputStream(dest))
				);
		dos.writeObject(emp);
		dos.close();
	}
	
}
