package cn.bjsxt.generic04;
/**
 * �����Ͳ�����ʹ��ʱȷ������
 * ��ʹ�� :�������͡����������ϣ�����������ʱʹ�ã�
 *  ��extends �������� <= ָ���������������
 * �� super �������� >= ָ������Ϊ�������
 * 
 * @author llf
 *
 */
public class Student<T> {
	T score;
	public static void main(String[] args) {
		Student<?> stu = new Student<String>();
		test(new Student<Integer>());
		test2(new Student<Apple>());
		//test3(new Student<Apple>());����û�ж�̬
		test4(new Student<Object>());
		
	}
	
	public static void test(Student<?> stu){
		
	}
	//<=
	public static void test2(Student<? extends Fruit> stu){
		
	}
	public static void test3(Student<Fruit> stu){
		
	}
	//>=
	public static void test4(Student<? super Fruit> stu){
		
	}
}
