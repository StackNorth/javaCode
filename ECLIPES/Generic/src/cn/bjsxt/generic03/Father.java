package cn.bjsxt.generic03;
/**
 * ����Ϊ������
 * @author llf
 *1����
 *2����
 *Ҫôͬʱ������Ҫô������ڵ��ڸ��������
 *����������������෺��
 *1����������
 * �����У��游�����
 * �������У����������
 * ������д�游�����
 * ���ͽӿ���̳�һ�� 
 */
public abstract class Father<T> {
	T name;
	public abstract void Test(T t);
}
class Child1 extends Father<String>{
	String t1;
	public void Test(String t) {
		
	}
}
/**
 * ����Ϊ�����࣬������ʹ��ʱȷ��
 * @author llf
 *
 * @param <T>
 */
class Child2 <T> extends Father<T>{
	T t2;
	
	public void Test(T t) {
	
	}
	
}

/**
����Ϊ�����࣬���಻ָ������,���͵Ĳ�����ʹ��Object�滻
*/
class Child3<T,T1> extends Father{
	T name2;
	public void Test(Object t) {
		
	}
	
}
/**
 * �����븸��ͬʱ����
 */
class Child4 extends Father{
	
	public void Test(Object t) {	
	}
}
/**����
class Child5 extends Father<T>{
	public void Test(T t) {
		// TODO Auto-generated method stub
		
	}
	
}
*/









