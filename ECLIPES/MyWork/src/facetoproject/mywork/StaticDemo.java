package facetoproject.mywork;

public class StaticDemo {
	private static int a = 10;
	private  int b = 5;//static�ؼ��־�̬�����ﲻ�ܵ��÷Ǿ�̬�Ķ�����ͨ��������Ե��þ�̬�Ķ��� 
	public static void main(String[] args) {
		StaticDemo s = new StaticDemo();
		System.out.println(a + s.b);
	}
}
