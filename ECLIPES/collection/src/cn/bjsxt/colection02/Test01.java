package cn.bjsxt.colection02;

import java.util.ArrayList;
import java.util.List;

public class Test01 {
	public static void main(String[] args){
		Employee e = new Employee(0301,"高琪",30000,"项目部","2007-10");
		Employee e2 = new Employee(0301,"马士兵",30000,"项目部","2007-9");
		Employee e3 = new Employee(0301,"培新",30000,"项目部","2007-10");
		List <Employee> list = new ArrayList<Employee>();
		
		list.add(e);
		list.add(e2);
		list.add(e3);
		printfEmpName(list);
	
		
	}
	public static void printfEmpName(List<Employee> list){
		for(int i = 0;i<list.size();i++){
			System.out.println(list.get(i).getName());
		}
	}
}
