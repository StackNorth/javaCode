package cn.bjsxt.generic04;
/**
 * 没有泛型数组
 * 声明可以用，但是创建失败
 * @author llf
 *
 */
public class Array {
	public static void main(String[] args) {
		int[] a = new int[10];
		//Student<String>[] stu = new Student<String>[10]; * 声明可以用，但是创建失败
		Student<?>[] stu = new Student[10];
		MyArrayList<String> str = new MyArrayList<>();
		str.add(0, "aaa");
//		str.getEilm(0);
		System.out.println( str.getEilm(0));
	}
}

class MyArrayList<E>{
	//E[] cap = new E[10];
	Object[] cap = new Object[10];
	
	public void add(int idx, E e){
		cap[idx] = e;
	}
	
	
	public E[] getAll(){
		return (E[]) cap;  
	}
	
	public E getEilm(int idx){
		return (E) cap[idx];
	}
	
	
}