package cn.bjsxt.collection;

import java.util.HashMap;

/**
 * �����Լ���set
 * 
 * @author llf
 *
 */
public class SxtHashSet {
	int size;
	HashMap map;
	private static final Object PESSENT = new Object();
	
	public int size(){
		return map.size();
	}
	
	public SxtHashSet(){
		map = new HashMap();
	}
	
	public void add(Object a){
		map.put(a, PESSENT);//�����ظ�������map���������Ĳ����ظ�
	}
	
	
	public static void main(String[] args) {
		SxtHashSet s = new SxtHashSet();
		s.add("aaa");
		s.add(new String ("aaa"));
		System.out.println(s.size());
	}
}
