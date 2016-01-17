package cn.bjsxt.collection;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
/**
 * 测试List中的基本方法
 * @author 邓涛
 *
 */
public class Test01 {
	public static void main(String[] args) {
		List list = new ArrayList();//常见     //数组查询快，链表修改快
		//ArrayList;底层实现时数组，线程不安全，效率高；所以，查询快，修改，插入，删除慢。
		//LinkedList；底层实现是链表线程不安全，效率高；所以，查询慢，修改，删除快
		//Vector；线程安全的，效率低；
		
		list.add("aaa");
		list.add(new Date());
		list.add(1234);//自动装箱
		list.add(new Dog());
		System.out.println(list.size());
		System.out.println(list.isEmpty());
		//list.remove("aaa");//可以指定某个索引位置进行移除  equals和hashcode
		//System.out.println(list.size());
		
		List list2 = new ArrayList();
		list2.add("bbb");
		list2.add("ccc");
		list.add(list2);
		
		//跟顺序有关的操作
		String str = (String) list.get(0);
		System.out.println(str);
		list.remove(0);
	}
}

class Dog{
	
}