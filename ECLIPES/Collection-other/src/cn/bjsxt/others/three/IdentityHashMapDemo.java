package cn.bjsxt.others.three;

import java.util.IdentityHashMap;

/**
 *  IdentityHashMapDemo 键比较地址去重
 * @author llf
 *
 */
public class IdentityHashMapDemo {
	public static void main(String[] args) {
		IdentityHashMap<String,String> map =new IdentityHashMap<String,String>(); 
		//常量池中的“a"
		
		map.put("a","a1");
		map.put("a","a2");
		System.out.println(map.size());
		map.put(new String("a"),"a3");
		map.put(new String("a"),"a4");
		System.out.println(map.size());
	}
}
