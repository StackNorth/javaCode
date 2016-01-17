package cn.bjsxt.collection;
/**
 * �Զ���ʵ��map�Ĺ���
 * ������
 * @author llf
 *Map:��ż�ֵ�ԣ����ݼ������Ҷ�Ӧ��ֵ����,�� �����ظ���
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