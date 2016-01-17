package cn.bjsxt.others.synch;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 使用collection管理同步容器
 * 主要使用方法：
 * synchronizedList()
 * synchronizedSet()
 * synchronizedMap()
 * @author llf
 *
 */
public class Demo01 {
	public static void main(String[] args) {
		List<String> list = new ArrayList<String>();
		list.add("a");
		list.add("b");
		//list可以同步
		List<String> snylist =Collections.synchronizedList(list);
		System.out.println("线程安全的list制作完毕");
	}
}
