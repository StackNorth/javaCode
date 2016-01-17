package cn.bjsxt.interator;

import java.util.Iterator;

/**
 * 加入接口，提供方法
 * @author llf
 *
 */
public class MyArrayList2 {
	private String[] eiem = {"a","b","c","d","e","f","g"};
	private int size = eiem.length;
	
	private class MyIt implements Iterator<String>{
	
	
		private int  cursor = -1;
		//判断是否存在下一个元素
		
		public boolean hasNext(){
			return cursor+1<size;
		}
		//获取下一个元素
		public String next(){
			cursor++;//移动一次 
			return eiem[cursor];	
		}
			//删除元素
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
