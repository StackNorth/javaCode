package cn.bjxst.io.convert;

import java.io.UnsupportedEncodingException;

public class ConvertDemo01 {
	public static void main(String[] args) {
		String str="中国";
		byte[] data=str.getBytes();
		System.out.println(new String(data,0,3));
	}
	/**
	 * 编码与解码字符集必须相同，否则乱码
	 * @throws UnsupportedEncodingException
	 */
	public static void test01()throws UnsupportedEncodingException {
		//解码 byte-->char
		String str="中国";//jbk
		//编码char-->byte
		byte[] data=str.getBytes();
		//编码与解码字符集统一
		System.out.println(new String(data));
		data =str.getBytes("utf-8");
		//编码与解码字符集不统一出现乱码
		System.out.println(new String(data));
		
		
		byte[] data2="中国".getBytes("utf-8");
		str = new String(data2,"utf-8");
		System.out.println(new String(str));
		
	}
}
