package cn.bjsxt.test;

public class Test02 {
	public static void main(String[] args){
		Integer a =1000;//�Զ�װ�䣬���˴���
		int  c = a;
		System.out.println(c);
		
		Integer d = 1234;
		Integer d1 = 1234;
		System.out.println(d == d1);
		System.out.println(d.equals(d1));
		Integer d3 = 123;  //[-128,127]֮����������籾��������������
		Integer d4 = 123;
		System.out.println(d3 == d4);
		System.out.println(d3.equals(d4));
	}
}
