package cn.bjsxt.sort.col;

import java.util.TreeSet;
/**
 * �ṩ�˽��ʽ��ҵ��������
 * @author llf
 *
 */
public class TreeSetDemo {
	public static void main(String[] args) {
		Person p1 = new Person("gaoqi",100);
		Person p2 = new Person("mashibing",90);
		Person p3 = new Person("laogong",120);
		Person p4 = new Person("liu",50);
		//���δ�ŵ�TreeSet������,ʹ�������ҵ����
		TreeSet<Person> person = new TreeSet<Person>(//�Ƚ���
				new java.util.Comparator<Person>(){

					
					public int compare(Person o1, Person o2) {
						
						return o1.getHandsome()-o2.getHandsome();
					}
					
				});
		person.add(p1);
		//ע�⣺TreeSet ���������ʱ�������ݸ��Ĳ���Ӱ��ԭ����˳��,��Ҫ�޸����ݣ���������ظ�
		person.add(p2);
		person.add(p3);
		person.add(p4);
		System.out.println(person);
	}
}
