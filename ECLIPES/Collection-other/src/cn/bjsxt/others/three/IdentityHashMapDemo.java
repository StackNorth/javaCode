package cn.bjsxt.others.three;

import java.util.IdentityHashMap;

/**
 *  IdentityHashMapDemo ���Ƚϵ�ַȥ��
 * @author llf
 *
 */
public class IdentityHashMapDemo {
	public static void main(String[] args) {
		IdentityHashMap<String,String> map =new IdentityHashMap<String,String>(); 
		//�������еġ�a"
		
		map.put("a","a1");
		map.put("a","a2");
		System.out.println(map.size());
		map.put(new String("a"),"a3");
		map.put(new String("a"),"a4");
		System.out.println(map.size());
	}
}
