package cn.bjsxt.generic04;
/**
 * ���͵�Ƕ��
 * @author llf
 *
 * @param <T>
 */
public class Bjxst<T> {
	T stu;
	
	public static void main(String[] args) {
		Bjxst<Student<String>> room = new Bjxst<Student<String>>();
		//���⵽�ڲ��
		room.stu = new Student<String>();
		Student<String> stu = room.stu;
		String score = stu.score;
		System.out.println(score);
		
	}
}
