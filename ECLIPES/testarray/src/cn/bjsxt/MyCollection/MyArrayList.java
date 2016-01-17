package cn.bjsxt.MyCollection;
/**
 * 模拟jdk中提供的的Arraylist类
 * @author llf
 *
 */
public class MyArrayList {
	private Object v[];
	private int size;
	
	public MyArrayList(){
	this(16);
	//	v = new Object[16];
	}
	
	public MyArrayList(int size){
		v = new Object[size];
	}
	
	public int size(){
		return size;	
	}
	
	public void add(Object obj){
		v[size] = obj;
		size++;
		
		if(size >= v.length){
			int newcapacity = v.length*2;
			Object[] newList = new Object[newcapacity];
			//System.arraycopy(src, srcPos, dest, destPos, length);
			for(int i = 0;i<v.length;i++){
				newList[i] = v[i];
			}
			v = newList;
			
		}
	}
	
	public Object get(int index){
		if(index > size-1 || index<0){
			try{
			throw new Exception();//手动抛出一个异常
			
			} catch (Exception e) {
			e.printStackTrace();
			}
		}	
		return v[index];
		
	}
	
	public static void main(String[] args){
		MyArrayList list = new MyArrayList(2);
		list.add("asd");
		list.add("bbbb");
		list.add(new Man("dngtao"));
		Man h = (Man)list.get(2);
		System.out.println(h.name);
		System.out.println(list.get(0));
	}
}
