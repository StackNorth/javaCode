package facetoproject.mywork;

public class StaticDemo {
	private static int a = 10;
	private  int b = 5;//static关键字静态方法里不能调用非静态的东西普通方法里可以调用静态的东西 
	public static void main(String[] args) {
		StaticDemo s = new StaticDemo();
		System.out.println(a + s.b);
	}
}
