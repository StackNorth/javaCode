package cn.bjsxt.oop.polymrophism;
/**
 * 测试多态
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
		Animal a= new Cat();//父类的引用指向一个子类的对象
		testAnimalVocie(a);
		
	}
}
