package cn.bjsxt.sort.col;

import java.util.TreeSet;
/**
 * ʵ����ʵ��compable��Ӧ��
 * @author llf
 *
 */
public class TreeSetDemo02 {
	
	public static void main(String[] args) {
		Worker w1 =new Worker("��������Ա",12000);
		Worker w2 =new Worker("ũ��",8000);
		Worker w3 =new Worker("����Ա",5000);
		
		TreeSet<Worker> employees = new TreeSet<Worker>();
		employees.add(w1);
		employees.add(w2);
		employees.add(w3);
		System.out.println(employees);
	}
}
