package cn.bjsxt.others.three;

import java.util.EnumMap;

/**
 * EnumMapҪ���Ϊö��
 * @author llf
 *
 */
public class EnumMapDemo01 {

	public static void main(String[] args) {
		EnumMap<Season,String> map= new EnumMap<Season,String>(Season.class);
		//���ֵ
		map.put(Season.SPRING,"����");
		map.put(Season.SUMMER,"����");
		map.put(Season.AUTUMN,"����");
		map.put(Season.WINTER,"����");
		System.out.println(map.size());
	}
	
}
 //����
enum Season{
	SPRING,SUMMER,AUTUMN,WINTER
	
}