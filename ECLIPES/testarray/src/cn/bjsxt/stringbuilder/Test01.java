package cn.bjsxt.stringbuilder;
/**
 * 测试可变字符序列，StringBuilder（线程不安全，效率高），StringBurrer（线程安全，效率低）
 * @author llf
 *
 */
public class Test01 {
	public static void main(String[] args){
		StringBuilder sb = new StringBuilder();//初始长度为
		StringBuilder sb1 = new StringBuilder(32);//初始长度为
		StringBuilder sb2 = new StringBuilder("abcd");//初始长度为
		sb2.append("efg").append(321).append("kjg");//方法连	
		System.out.println(sb2);
		System.out.println("########################");
		StringBuilder gh = new StringBuilder("a");
		for(int i = 0; i <1000;i++)
		{
			gh.append(i);
		}
		System.out.println(gh);
	}
}
