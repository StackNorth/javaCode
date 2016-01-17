package cn.bjsxt.collection;

import java.util.HashSet;
import java.util.Set;

/**
 * 测试常用方法
 * @author llf
 *
 */
public class TestSet {
	public static void main(String[] args) {
		Set set = new HashSet();
		set.add("aaa");
		System.out.println(set.size());
	}
}
