package cn.bjsxt.interator;
/**
 * 简化迭代器原理
 * @author llf
 *
 */
public class MyArrayList {
	private String[] eiem = {"a","b","c","d","e","f","g"};
	private int size = eiem.length;
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
	public static void main(String[] args) {
		MyArrayList list = new MyArrayList();
		while(list.hasNext()){
			System.out.println(list.next());
		}
	}
	
}
