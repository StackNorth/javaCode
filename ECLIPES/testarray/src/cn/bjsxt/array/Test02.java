package cn.bjsxt.array;

public class Test02 {
	public static void main(String[] args){
		//声明
		int[] a;
		int b[];
		//创建数组
		a = new int[4];
		b = new int[5];		
		
		//初始化(对数组元素的初始化）
		//数组袁术相当于对象的成员变量，系统默认初始化；
		//动态初始化
		a[0] = 23;
		
		for(int i = 0;i < a.length;i++)
			a[i] = i*12;
		//静态初始化
		int c[] = {1,2,3,4,5,6,7}; 
		Car[] cars = {new Car("benchi"),new Car("baoma")};
		Car c2 = new Car("benchi");
		System.out.println(c2 == cars[0]);
		 
	}

	
}
