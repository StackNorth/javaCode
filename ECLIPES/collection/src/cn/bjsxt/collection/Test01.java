package cn.bjsxt.collection;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
/**
 * ����List�еĻ�������
 * @author ����
 *
 */
public class Test01 {
	public static void main(String[] args) {
		List list = new ArrayList();//����     //�����ѯ�죬�����޸Ŀ�
		//ArrayList;�ײ�ʵ��ʱ���飬�̲߳���ȫ��Ч�ʸߣ����ԣ���ѯ�죬�޸ģ����룬ɾ������
		//LinkedList���ײ�ʵ���������̲߳���ȫ��Ч�ʸߣ����ԣ���ѯ�����޸ģ�ɾ����
		//Vector���̰߳�ȫ�ģ�Ч�ʵͣ�
		
		list.add("aaa");
		list.add(new Date());
		list.add(1234);//�Զ�װ��
		list.add(new Dog());
		System.out.println(list.size());
		System.out.println(list.isEmpty());
		//list.remove("aaa");//����ָ��ĳ������λ�ý����Ƴ�  equals��hashcode
		//System.out.println(list.size());
		
		List list2 = new ArrayList();
		list2.add("bbb");
		list2.add("ccc");
		list.add(list2);
		
		//��˳���йصĲ���
		String str = (String) list.get(0);
		System.out.println(str);
		list.remove(0);
	}
}

class Dog{
	
}