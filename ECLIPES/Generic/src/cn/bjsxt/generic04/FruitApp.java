package cn.bjsxt.generic04;
/**
 * ��̬��������ʽ
 * @author llf
 *
 */
public class FruitApp {
	public static void main(String[] args) {
		Fruit f = new Apple();
		
	}
	//�β�ʹ�ö�̬
	public static void test(Fruit f){
		
	}
	//��������ʹ�ö�̬
	public static Fruit test2(){
		return new Apple();
	}
}
