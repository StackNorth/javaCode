package cn.bjxst.io.convert;
import java.io.*;

/**
 * 转换流：字节转为字符
 * 1、输出流：OutputStreamWriter 编码
 * 	   输入流：InputStreamReader  解码
 * @author llf
 *
 */
public class ConvertDemo02 {
	public static void main(String[] args) throws IOException {
		//指定解码的字符集
		BufferedReader rd= new BufferedReader(new InputStreamReader
				(new FileInputStream(new File("E:/Java/abc.txt")),"utf-8"));
		BufferedWriter rv=new BufferedWriter(new FileWriter("E:/Java/cde.java"));
		
		
		String info = null;
		while(null!=(info=rd.readLine())){
			rv.write(info);
			rv.newLine();
			
		}
		rv.flush();
		rv.close();//文件写完后必须关闭才能结束
		rd.close();
	}
}
