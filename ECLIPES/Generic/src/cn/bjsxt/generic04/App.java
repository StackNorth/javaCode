package cn.bjsxt.generic04;
//泛型没有多态
public class App {
	public static void main(String[] args) {
	//错误	A<Fruit> f1 = new A<Apple>();	
		A<Fruit> f = new A<Fruit>();
	}
	
	//形参使用多态
		public static void test(A<Fruit> f){
			
		}
		//返回类型使用多态
		public static A<Fruit> test2(){
			//return (A<Fruit>)(new A<Apple>());
			return null;
		} 
}
