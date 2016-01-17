package cn.bjsxt.sort.col;

import java.util.Set;
import java.util.TreeMap;

public class TreeMapDemo01 {

	public static void main(String[] args) {
		Person p1 = new Person("gaoqi",100);
		Person p2 = new Person("mashibing",90);
		Person p3 = new Person("laogong",120);
		Person p4 = new Person("liu",50);
	
		TreeMap<Person, String> map = new TreeMap<Person, String>(new java.util.Comparator<Person>(){

			
			public int compare(Person o1, Person o2) {
				
				return o1.getHandsome()-o2.getHandsome();
			}
			
		});
		map.put(p1,"bjsxt");
		map.put(p2,"bjsxt");
		map.put(p3,"bjsxt");
		map.put(p4,"bjsxt");
		//²é¿´¼ü
		Set<Person> persons = map.keySet();
		System.out.print(persons);
	}
	
	
}
