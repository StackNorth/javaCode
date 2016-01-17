package cn.bjsxt.others.three;

import java.util.EnumMap;

/**
 * EnumMap要求键为枚举
 * @author llf
 *
 */
public class EnumMapDemo01 {

	public static void main(String[] args) {
		EnumMap<Season,String> map= new EnumMap<Season,String>(Season.class);
		//存放值
		map.put(Season.SPRING,"春困");
		map.put(Season.SUMMER,"夏天");
		map.put(Season.AUTUMN,"秋天");
		map.put(Season.WINTER,"冬天");
		System.out.println(map.size());
	}
	
}
 //季节
enum Season{
	SPRING,SUMMER,AUTUMN,WINTER
	
}