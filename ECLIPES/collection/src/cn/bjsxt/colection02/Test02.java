package cn.bjsxt.colection02;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Test02 {
	public static void main(String[] args) {
		Map map = new HashMap();
		map.put("id", 0301);
		map.put("name", "����");
		map.put("salary", 3000);
		map.put("department", "��Ŀ��");
		map.put("hiredate", "2007-10");
		
		Map map2 = new HashMap();
		map2.put("id", 0302);
		map2.put("name", "��ʿ��");
		map2.put("salary", 3000);
		map2.put("department", "��Ŀ��");
		map2.put("hiredate", "2007-10");
		
		Map map3 = new HashMap();
		map3.put("id", 0303);
		map3.put("name", "����");
		map3.put("salary", 3000);
		map3.put("department", "��Ŀ��");
		map3.put("hiredate", "2007-10");
		
	List <Map> list = new ArrayList<Map>();
		
		list.add(map);
		list.add(map2);
		list.add(map3);
		printfEmpName(list);
		
		
		
	}
	
	public static void printfEmpName(List<Map> list){
		for(int i = 0;i<list.size();i++){
			Map tempmap = list.get(i);
			System.out.println(tempmap.get("name"));
		}
	}
}
