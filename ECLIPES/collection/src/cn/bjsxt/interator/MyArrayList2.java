package cn.bjsxt.interator;

import java.util.Iterator;

/**
 * ����ӿڣ��ṩ����
 * @author llf
 *
 */
public class MyArrayList2 {
	private String[] eiem = {"a","b","c","d","e","f","g"};
	private int size = eiem.length;
	
	private class MyIt implements Iterator<String>{
	
	
		private int  cursor = -1;
		//�ж��Ƿ������һ��Ԫ��
		
		public boolean hasNext(){
			return cursor+1<size;
		}
		//��ȡ��һ��Ԫ��
		public String next(){
			cursor++;//�ƶ�һ�� 
			return eiem[cursor];	
		}
			//ɾ��Ԫ��
		public void remove(int idx){
			
		}
	}
	
	public Iterator<String> Iterator(){
		return new MyIt();
	}
	
	public static void main(String[] args) {
		MyArrayList2 list = new MyArrayList2();
		Iterator<String> it = list.Iterator();
		while(it.hasNext()){
			System.out.println(it.next());
		}
	}
	
}
