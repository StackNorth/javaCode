package cn.bjsxt.map;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * this is a cat and that is a mice and where the food?
 * ͳ��ÿ���������Եô���
 * 
 * �洢��map��
 * @author llf
 *���ּ�˼·��
 *1 Ϊ���е�key����������֮��������Ŷ��õ�value
 *2 ��һ�δ��������������value
 *�ڶ���֮��ֱ��ʹ���������ֵ��
 */
public class Deno01 {
	
	
	public static void main(String[] args) {
		String str = "this is a cat and that is a mice and where the food";
		//�ָ��ַ�����
		String[] strArray = str.split(" ");
		//�洢��map��
		Map<String,Letter> letters = new HashMap<String,Letter>();
		for(String temp:strArray){//��һ��ֵ����������
			/*
			if(!letters.containsKey(temp)){//containskey�Ƿ����ָ���ļ���
				Letter col = new Letter();
				col.setCount(1);
				letters.put(temp,col);
			}else{//�ڶ���֮��ֱ��ʹ���������ֵ
			Letter col = letters.get(temp);//ֱ��ʹ������
			col.setCount(col.getCount()+1);
			}
			 */
			Letter col = null;
			if(null == (col=letters.get(temp))){//containskey�Ƿ����ָ���ļ���
				 col = new Letter();
				 col.setCount(1);
				 letters.put(temp,col);
			}else{//�ڶ���֮��ֱ��ʹ���������ֵ
				col = letters.get(temp);//ֱ��ʹ������
				col.setCount(col.getCount()+1);
		}
		
		//���map��ֵ
				Set<String> keys = letters.keySet();
				for(String key:keys){
					 col = letters.get(key);//ֱ��ʹ������
					System.out.println("��ĸ" + key + "����" + col.getCount());
				}
				
		}
		
		
		
	}
	
	public static void test01(){
		String str = "this is a cat and that is a mice and where the food";
		//�ָ��ַ�����
		String[] strArray = str.split(" ");
		//�洢��map��
		Map<String,Letter> letters = new HashMap<String,Letter>();
		/*for(String temp:strArray){
			//Ϊ���е�key��������
			if(!letters.containsKey(temp)){
				letters.put(temp, new Letter());
			}
		}
		//��Ŷ�Ӧ��value
		for(String temp:strArray){
			Letter col = letters.get(temp);
			col.setCount(col.getCount()+1);
		}
		*/
		for(String temp:strArray){
			if(!letters.containsKey(temp)){//containskey�Ƿ����ָ���ļ���
				letters.put(temp, new Letter());
			}
			Letter col = letters.get(temp);//ֱ��ʹ������
			col.setCount(col.getCount()+1);
		}
		
		
		//���map��ֵ
		Set<String> keys = letters.keySet();
		for(String key:keys){
			Letter col = letters.get(key);//ֱ��ʹ������
			System.out.println("��ĸ" + key + "����" + col.getCount());
		}
		
		
	}
}
