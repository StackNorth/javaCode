package cn.bjsxt.collection;

import java.util.HashMap;
import java.util.Map;

/**
 * 测试Map的基本用法
 * @author llf
 *
 */
public class TestMap {
	public static void main(String[] args) {
		Map map = new HashMap();
		map.put("gaoqi",new Wife("zhangmanyu"));
		map.put("zhangsan", new Wife("ym"));
		
		map.remove("gaoqi");//移除，不是删除
		
		map.containsKey("zhangsan");
		
		
		
		Wife w = (Wife) map.get("gaoqi");
		System.out.println(w.name); 
		
	}
}

class Wife{
	String name;
	public Wife(String name){
		this.name = name;
	}
}