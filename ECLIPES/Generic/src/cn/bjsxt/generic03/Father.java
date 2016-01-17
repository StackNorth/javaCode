package cn.bjsxt.generic03;
/**
 * 父类为泛型类
 * @author llf
 *1属性
 *2方法
 *要么同时擦除，要么子类大于等于父类的类型
 *不能子类擦除，父类泛型
 *1、属性类型
 * 父类中，随父类而定
 * 在子类中，随子类而定
 * 方法重写随父类而定
 * 泛型接口与继承一样 
 */
public abstract class Father<T> {
	T name;
	public abstract void Test(T t);
}
class Child1 extends Father<String>{
	String t1;
	public void Test(String t) {
		
	}
}
/**
 * 子类为泛型类，类型在使用时确定
 * @author llf
 *
 * @param <T>
 */
class Child2 <T> extends Father<T>{
	T t2;
	
	public void Test(T t) {
	
	}
	
}

/**
子类为泛型类，父类不指定类型,泛型的擦除，使用Object替换
*/
class Child3<T,T1> extends Father{
	T name2;
	public void Test(Object t) {
		
	}
	
}
/**
 * 子类与父类同时擦除
 */
class Child4 extends Father{
	
	public void Test(Object t) {	
	}
}
/**错误：
class Child5 extends Father<T>{
	public void Test(T t) {
		// TODO Auto-generated method stub
		
	}
	
}
*/









