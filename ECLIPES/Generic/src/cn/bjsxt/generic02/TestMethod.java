package cn.bjsxt.generic02;
/**
 * 泛型方法<>返回类型
 * 泛型方法只能访问对象的信息，不能修改信息
 * @author llf
 *
 */
public class TestMethod {
	public static void main(String[] args) {
		test("a");
	}
	public static <T> void test(T t){
		System.out.println(t);
	}
}
