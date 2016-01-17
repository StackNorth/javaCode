package cn.bjsxt.sort.col;

import java.util.TreeSet;
/**
 * 提供了解耦方式，业务排序类
 * @author llf
 *
 */
public class TreeSetDemo {
	public static void main(String[] args) {
		Person p1 = new Person("gaoqi",100);
		Person p2 = new Person("mashibing",90);
		Person p3 = new Person("laogong",120);
		Person p4 = new Person("liu",50);
		//依次存放到TreeSet容器中,使用排序的业务类
		TreeSet<Person> person = new TreeSet<Person>(//比较器
				new java.util.Comparator<Person>(){

					
					public int compare(Person o1, Person o2) {
						
						return o1.getHandsome()-o2.getHandsome();
					}
					
				});
		person.add(p1);
		//注意：TreeSet 在添加数据时排序，数据更改不会影响原来的顺序,不要修改数据，否则可能重复
		person.add(p2);
		person.add(p3);
		person.add(p4);
		System.out.println(person);
	}
}
