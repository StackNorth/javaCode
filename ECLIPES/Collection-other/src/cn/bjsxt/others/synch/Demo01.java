package cn.bjsxt.others.synch;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * ʹ��collection����ͬ������
 * ��Ҫʹ�÷�����
 * synchronizedList()
 * synchronizedSet()
 * synchronizedMap()
 * @author llf
 *
 */
public class Demo01 {
	public static void main(String[] args) {
		List<String> list = new ArrayList<String>();
		list.add("a");
		list.add("b");
		//list����ͬ��
		List<String> snylist =Collections.synchronizedList(list);
		System.out.println("�̰߳�ȫ��list�������");
	}
}
