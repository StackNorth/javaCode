package cn.bjsxt.string;
/**
 * string 类的常用方法
 * 结合数组查看源码
 * @author llf
 *
 */
public class TestString {
	public static void main(String[] args){
		String str = "abcd";
		String str2 = "abcd";
		System.out.println(str.charAt(2));
		System.out.println(str.equals(str2));
		
		String str3 = "def";
		String str4 = "def";
		System.out.println(str3.equals(str4));
		System.out.println(str3 == str4);
		System.out.println(str3.indexOf("e"));
		String s = str3.substring(0);
		System.out.println(s);
		String str5 = str3.replace('e','g');
		System.out.println(str5);
		String str6 = "abcde,rrttrt,sfsdf";
		String[] strarray = str6.split(",");
		for(int i = 0; i<strarray.length;i++){
			System.out.println(strarray[i]);
			String str7 = " aa  bb ";
			String str77 = str7.trim();
			System.out.println(str77.length());
			
		}
	}
}
