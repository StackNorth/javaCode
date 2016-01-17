package cn.bjsxt.collection;

import java.util.HashMap;

/**
 * 定义自己的set
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
		map.put(a, PESSENT);//不可重复利用了map里面键对象的不可重负
	}
	
	
	public static void main(String[] args) {
		SxtHashSet s = new SxtHashSet();
		s.add("aaa");
		s.add(new String ("aaa"));
		System.out.println(s.size());
	}
}
