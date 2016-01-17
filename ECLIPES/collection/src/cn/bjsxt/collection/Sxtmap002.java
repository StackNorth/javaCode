package cn.bjsxt.collection;

import java.util.LinkedList;

/**
 * ��߲�ѯ��Ч��  �����������������ٱ����Ĵ���
 * @author llf
 *
 */
public class Sxtmap002 {
	LinkedList[] arr = new LinkedList[999]; //Map�ĵײ�ṹ�����������
	int size;
	
	public void put(Object key,Object value){
		SxtEntry e = new SxtEntry(key,value);
		int hash = key.hashCode();
		hash = hash<0?-hash:hash;
		int a = key.hashCode()%arr.length;
		if(arr[a] == null){
			LinkedList list = new LinkedList();
			arr[a] = list;
			list.add(a);
		}else{
			LinkedList list =arr[a];
			for(int i = 0;i<list.size();i++){
				SxtEntry e2 = (SxtEntry) list.get(i);
				if(e2.key.equals(key)){
				 e2.value = value;
				 return; 
				}
			}

			arr[a].add(e);
		}
		
//		System.out.println(key.hashCode());
	}
	
	public Object get(Object key){
		int a = key.hashCode()%arr.length;
		if(arr[a] != null){
			LinkedList list =arr[a];
			for(int i = 0;i<list.size();i++){
				SxtEntry e = (SxtEntry) list.get(i);
				if(e.key.equals(key)){
					return e.value;
				}
			}
		}
		return null;
	}
	
	public static void main(String[] args) {
		Sxtmap002 w = new Sxtmap002();
		w.put("����", new Wife("Ҧ��"));
		w.put("����", new Wife("����"));
		Wife wife = (Wife)w.get("����");
		System.out.println(wife.name); 
	} 
	
}



