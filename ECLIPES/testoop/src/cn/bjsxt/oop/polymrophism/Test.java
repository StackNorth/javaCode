package cn.bjsxt.oop.polymrophism;
/**
 * ���Զ�̬
 * @author llf
 *
 */
public class Test {
	public static void testAnimalVocie(Animal c){
		c.voice();
		if ( c instanceof Cat){
			((Cat) c).catchMouse();
		}
	}
	/*
		public static void testAnimalVocie(Pig p){
		p.voice();
		
	}
	
	public static void testAnimalVocie(Dog d){
		d.voice();
		
	}
	*/
	public static void main(String[] args){
		Animal a= new Cat();//���������ָ��һ������Ķ���
		testAnimalVocie(a);
		
	}
}
