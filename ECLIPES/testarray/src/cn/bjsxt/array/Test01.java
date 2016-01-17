package cn.bjsxt.array;
/**
 * 数组的基本概念 
 * 
 * @author llf
 *
 */
public class Test01 {
	public static void main(String[] args){
		int[] a = new int[3];//引用类型int[];
		a[0] = 23;
		a[1] = 22;
		a[2] = 21;
		
		Car[] cars = new Car[4];
		cars[0] = new Car("baoma");
		cars[1] = new Car("biyadi");
		System.out.println(cars[0].name);
		System.out.println(cars.length);
		for(int i = 0; i<a.length;i++){
			System.out.println(a[i]);
		}
	}
}
