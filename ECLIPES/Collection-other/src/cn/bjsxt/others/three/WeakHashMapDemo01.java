package cn.bjsxt.others.three;

import java.util.WeakHashMap;

/**WeakHashMap��Ϊ�����ͣ�gc������������
 * 
 * @author llf
 *
 */
public class WeakHashMapDemo01 {
	public static void main(String[] args) {
		WeakHashMap<String,String> map = new WeakHashMap<String,String>();
		//��������
		//�����ض��� �������
		map.put("abc","a");
		map.put("d","test");
		//gc���У��ѱ�����
		map.put(new String("bjsct"),"c");
		map.put(new String("dsf"), "d");
		//֪ͨ����
		System.gc();
		System.runFinalization();
		System.out.println(map.size());
	}
		
		
	
}
