package cn.bjsxt.others.en;

import java.util.Enumeration;
import java.util.Vector;

/**
 * Enumeration��ʹ��
 * 1���ж�hasMoreElements();
 * 2����ȡ nextElements������
 * @author llf
 *Vector��elements�����ķ���
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
