package cn.bjsxt.others.en;

import java.util.StringTokenizer;

/**
 * Enumeration������
 * StringTokenizer������String.split()һ���ָ��ַ�����
 * ��֧��������ʽ

 * @author llf
 *
 */
public class Demo02 {
	public static void main(String[] args) {
		String enmailStr = "bjxst@163.com;bjsxt@qq.com;bjxst@sohu.com";
		StringTokenizer token = new StringTokenizer(enmailStr,";");
		//������ȡ
		while(token.hasMoreElements()){
		System.out.println(token.nextElement());

		}
	}
}