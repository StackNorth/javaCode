package cn.bjsxt.interator;
/**
 * �򻯵�����ԭ��
 * @author llf
 *
 */
public class MyArrayList {
	private String[] eiem = {"a","b","c","d","e","f","g"};
	private int size = eiem.length;
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
	public static void main(String[] args) {
		MyArrayList list = new MyArrayList();
		while(list.hasNext()){
			System.out.println(list.next());
		}
	}
	
}
