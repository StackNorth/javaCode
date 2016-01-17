package cn.bjsxt.others.en;

import java.util.Enumeration;
import java.util.Vector;

/**
 * Enumeration的使用
 * 1、判断hasMoreElements();
 * 2、获取 nextElements（）；
 * @author llf
 *Vector的elements（）的方法
 */
public class Demo01 {
	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		Vector<String> v = new Vector<String>();
		v.add("javase");
		v.add("html");
		v.add("oracle");
		Enumeration en = v.elements();
		while(en.hasMoreElements()){
			System.out.println(en.nextElement());
		}
	}
}
