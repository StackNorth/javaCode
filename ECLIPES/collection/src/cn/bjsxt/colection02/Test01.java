package cn.bjsxt.colection02;

import java.util.ArrayList;
import java.util.List;

public class Test01 {
	public static void main(String[] args){
		Employee e = new Employee(0301,"����",30000,"��Ŀ��","2007-10");
		Employee e2 = new Employee(0301,"��ʿ��",30000,"��Ŀ��","2007-9");
		Employee e3 = new Employee(0301,"����",30000,"��Ŀ��","2007-10");
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
