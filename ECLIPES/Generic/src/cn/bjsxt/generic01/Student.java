package cn.bjsxt.generic01;
/**
 * Object 可以使用任意类型，因为发生多态
 * @author llf
 *
 */
public class Student {
	private Object  javase;
	private Object  oracle;
	
	
	
	
	public Student(Object javase, Object oracle) {
		super();
		this.javase = javase;
		this.oracle = oracle;
	}
	public Object getJavase() {
		return javase;
	}
	public void setJavase(Object javase) {
		this.javase = javase;
	}
	public Object getOracle() {
		return oracle;
	}
	public void setOracle(Object oracle) {
		this.oracle = oracle;
	}
	
}
