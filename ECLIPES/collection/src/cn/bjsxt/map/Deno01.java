package cn.bjsxt.map;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * this is a cat and that is a mice and where the food?
 * 统计每个单词书显得次数
 * 
 * 存储的map中
 * @author llf
 *“分拣”思路；
 *1 为所有的key创建容器，之后容器存放对用的value
 *2 第一次创建容器，并存放value
 *第二次之后直接使用容器存放值；
 */
public class Deno01 {
	
	
	public static void main(String[] args) {
		String str = "this is a cat and that is a mice and where the food";
		//分割字符串；
		String[] strArray = str.split(" ");
		//存储到map中
		Map<String,Letter> letters = new HashMap<String,Letter>();
		for(String temp:strArray){//第一次值放在容器中
			/*
			if(!letters.containsKey(temp)){//containskey是否包含指定的键名
				Letter col = new Letter();
				col.setCount(1);
				letters.put(temp,col);
			}else{//第二次之后，直接使用容器存放值
			Letter col = letters.get(temp);//直接使用容器
			col.setCount(col.getCount()+1);
			}
			 */
			Letter col = null;
			if(null == (col=letters.get(temp))){//containskey是否包含指定的键名
				 col = new Letter();
				 col.setCount(1);
				 letters.put(temp,col);
			}else{//第二次之后，直接使用容器存放值
				col = letters.get(temp);//直接使用容器
				col.setCount(col.getCount()+1);
		}
		
		//输出map的值
				Set<String> keys = letters.keySet();
				for(String key:keys){
					 col = letters.get(key);//直接使用容器
					System.out.println("字母" + key + "次数" + col.getCount());
				}
				
		}
		
		
		
	}
	
	public static void test01(){
		String str = "this is a cat and that is a mice and where the food";
		//分割字符串；
		String[] strArray = str.split(" ");
		//存储到map中
		Map<String,Letter> letters = new HashMap<String,Letter>();
		/*for(String temp:strArray){
			//为所有的key创建容器
			if(!letters.containsKey(temp)){
				letters.put(temp, new Letter());
			}
		}
		//存放对应的value
		for(String temp:strArray){
			Letter col = letters.get(temp);
			col.setCount(col.getCount()+1);
		}
		*/
		for(String temp:strArray){
			if(!letters.containsKey(temp)){//containskey是否包含指定的键名
				letters.put(temp, new Letter());
			}
			Letter col = letters.get(temp);//直接使用容器
			col.setCount(col.getCount()+1);
		}
		
		
		//输出map的值
		Set<String> keys = letters.keySet();
		for(String key:keys){
			Letter col = letters.get(key);//直接使用容器
			System.out.println("字母" + key + "次数" + col.getCount());
		}
		
		
	}
}
