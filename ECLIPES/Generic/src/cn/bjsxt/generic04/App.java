package cn.bjsxt.generic04;
//����û�ж�̬
public class App {
	public static void main(String[] args) {
	//����	A<Fruit> f1 = new A<Apple>();	
		A<Fruit> f = new A<Fruit>();
	}
	
	//�β�ʹ�ö�̬
		public static void test(A<Fruit> f){
			
		}
		//��������ʹ�ö�̬
		public static A<Fruit> test2(){
			//return (A<Fruit>)(new A<Apple>());
			return null;
		} 
}
