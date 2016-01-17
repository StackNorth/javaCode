package cn.bjsxt.others.en;

import java.util.StringTokenizer;

/**
 * Enumeration的子类
 * StringTokenizer作用与String.split()一样分割字符串；
 * 不支持正则表达式

 * @author llf
 *
 */
public class Demo02 {
	public static void main(String[] args) {
		String enmailStr = "bjxst@163.com;bjsxt@qq.com;bjxst@sohu.com";
		StringTokenizer token = new StringTokenizer(enmailStr,";");
		//遍历获取
		while(token.hasMoreElements()){
		System.out.println(token.nextElement());

		}
	}
}