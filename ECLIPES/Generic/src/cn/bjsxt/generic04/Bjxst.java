package cn.bjsxt.generic04;
/**
 * 泛型的嵌套
 * @author llf
 *
 * @param <T>
 */
public class Bjxst<T> {
	T stu;
	
	public static void main(String[] args) {
		Bjxst<Student<String>> room = new Bjxst<Student<String>>();
		//从外到内拆分
		room.stu = new Student<String>();
		Student<String> stu = room.stu;
		String score = stu.score;
		System.out.println(score);
		
	}
}
