package cn.bjsxt.others.synch;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 只读设置
 * emptyXxx() 空的不可变的集合
 * 	1、emptyList();
 * 	2、emptySet（）；
 * 	3、emptyMap（）；
 * singletonXxx()一个元素不可变的集合
 * 方法与上类似
 * unmodifiableXxx()不可变容器
 * @author llf
 *
 */
public class Demo02 {
	public static void main(String[] args) {
		Map<String,String> map =new HashMap<String,String>();
		map.put("test", "test");
		map.put("bjsxt", "bjsxt");
		//只读控制
		Map<String,String>map2 = Collections.unmodifiableMap(map);
		//map2.put("a", "a");不能操作
		//System.out.println(map.size());
		
		
		//一个元素的容器测试
		List<String> list =Collections.singletonList(new String());
		list.add("test");
		System.out.println(list.size());
	
	}
	
	public static Set<String> oper(Set<String> set){
		if(null==set){
			return Collections.EMPTY_SET;//外部获取避免NullPointerException
		}
		//操作
		return set;
	}
}
