package cn.bjsxt.collection;
/**
 * 自定义实现map的功能
 * 不完美
 * @author llf
 *Map:存放键值对，根据键对象找对应的值对象,键 不能重复；
 */
public class Sxtmap001 {
	SxtEntry[] arr = new SxtEntry[990]; 
	int size;
	
	public void put(Object key,Object value){
		SxtEntry e = new SxtEntry(key , value);
		for(int i=0;i <= size; i++){
			if (arr[i].key.equals(key)){
				arr[i].value = value;
				return;
			}
		}
		arr[size++] = e;
	}
	
	public Object get(Object key){
		for(int i=0;i <= size; i++){
			if (arr[i].key.equals(key)){
				return arr[i].value;
			}
		}
		return null;
	}
	
	public boolean containsKey(Object key){
		for(int i=0;i <= size; i++){
			if (arr[i].key.equals(key)){
				return true;
			}
		}
		return false;
	}
	
	public static void main(String[] args) {
		Sxtmap001 m = new Sxtmap001();
		m.put("zs", new Wife("ym"));
		m.put("zs", new Wife("yn"));
		Wife w = (Wife)m.get("zs");
		System.out.println(w.name);
	}
}


class SxtEntry{
	Object key;
	Object value;
	public SxtEntry(Object key, Object value) {
		super();
		this.key = key;
		this.value = value;
	}
	
}