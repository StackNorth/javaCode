package cn.bjsxt.collection;

import java.util.ArrayList;
import java.util.List;

/**
 * 自己实现一个arraylist，理解底层结构
 * @author llf
 *
 */
public class SetArrayList {
	private Object[] elementDate;
	private int size;
	
	public int size(){
		return size;
	} 
	
	public boolean isEmpty(){
		return size == 0;
	}
	
	public SetArrayList(){
		this(10);
	}
	
	public SetArrayList(int initialCapacity) {
		if(initialCapacity < 0){
			try {
				throw new Exception();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		elementDate = new Object[initialCapacity];
	}
	
	public void add(Object e){
		//数组扩容和数据的copy
		if(size+1 > elementDate.length){
			Object[] newArray = new Object[size*2 + 1];
			System.arraycopy(elementDate, 0, newArray, 0, elementDate.length);//copy数组
			elementDate = newArray;
		}
		
		elementDate[size] = e;
		size++;
	}
	
	public void add(int index, Object obj){
		rangeChex(index);
		ensureCapacity();//数组扩容
		System.arraycopy(elementDate, index, elementDate, index+1, size - index);
		elementDate[index] = obj;
		size++;
	}
	
	
	public Object get(int index){
		rangeChex(index);
		return elementDate[index];
	}
	
	private void rangeChex(int index){
		if( index >= size){
			try {
				throw new Exception();
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}
	}
	public void remove(int index){
		rangeChex(index);
		
		//删除指定位置的对象
		int  numMoved = size - index - 1;
		if(numMoved > 0){
			System.arraycopy(elementDate, index+1, elementDate, index, numMoved);
		}
		elementDate [--size] = null;
	}
	
	public void remove(Object obj){
		for(int i=0; i < size;i++){
			if(get(i).equals(obj)){
				remove(i);
			}//调用的是equals，不是==
		}
	}
	
	public Object set(int index, Object obj){
		rangeChex(index);
		 Object oldValue = elementDate[index];
		 elementDate[index] = obj;
		 return oldValue;
	}
	
	private void ensureCapacity(){
		if(size+1 > elementDate.length){
			Object[] newArray = new Object[size*2 + 1];
			System.arraycopy(elementDate, 0, newArray, 0, elementDate.length);//copy数组
			elementDate = newArray;
		}
	}
	
	public static void main(String[] args) {
		SetArrayList list = new SetArrayList(3);
		list.add("333");
		list.add("334");
		list.add("533");
		list.add("353");
		list.add("355");
		System.out.println(list.size());
		System.out.println(list.get(5));
	}
	
}
