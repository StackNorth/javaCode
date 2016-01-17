package cn.bjsxt.others.synch;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * ֻ������
 * emptyXxx() �յĲ��ɱ�ļ���
 * 	1��emptyList();
 * 	2��emptySet������
 * 	3��emptyMap������
 * singletonXxx()һ��Ԫ�ز��ɱ�ļ���
 * ������������
 * unmodifiableXxx()���ɱ�����
 * @author llf
 *
 */
public class Demo02 {
	public static void main(String[] args) {
		Map<String,String> map =new HashMap<String,String>();
		map.put("test", "test");
		map.put("bjsxt", "bjsxt");
		//ֻ������
		Map<String,String>map2 = Collections.unmodifiableMap(map);
		//map2.put("a", "a");���ܲ���
		//System.out.println(map.size());
		
		
		//һ��Ԫ�ص���������
		List<String> list =Collections.singletonList(new String());
		list.add("test");
		System.out.println(list.size());
	
	}
	
	public static Set<String> oper(Set<String> set){
		if(null==set){
			return Collections.EMPTY_SET;//�ⲿ��ȡ����NullPointerException
		}
		//����
		return set;
	}
}
