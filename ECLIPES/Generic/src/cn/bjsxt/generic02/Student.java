package cn.bjsxt.generic02;
/**
 * 泛型类：声明时使用泛型
 * 字母：随便定义，常见字母：T K V E ?
 * @author llf
 *使用时确定类型
 *注意：
 *1、泛型只能使用引用类型，不能使用基本类型
 *2、泛型声明时：不能使用静态的方法或属性
 * @param <T>
 */
public class Student<T1,T2> {
	private T1 javaScore;
	private T2 oracleScore;
	
	
	
	public T1 getJavaScore() {
		return javaScore;
	}



	public void setJavaScore(T1 javaScore) {
		this.javaScore = javaScore;
	}



	public T2 getOracleScore() {
		return oracleScore;
	}



	public void setOracleScore(T2 oracleScore) {
		this.oracleScore = oracleScore;
	}



	public static void main(String[] args) {
		//使用时指定类型
		Student<String,Integer> s = new Student<String,Integer>();
		//进行类型检查
		s.setJavaScore("优秀");
		//类型转换
		int i = s.getOracleScore();//自动拆箱
	}
}
