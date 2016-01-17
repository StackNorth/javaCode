package cn.bjsxt.others.pro;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

/**
 * 使用properties读取配置文件
 *.properties
 * load(InputStream inStream) 
 load(Reader reader) 
 * .xml
 * loadFromXML(InputStream in)  
 * @author llf
 *
 */
public class Demo03 {
	public static void main(String[] args) throws FileNotFoundException, IOException {
		Properties pro = new Properties();
		//读取绝对路径
		pro.load(new FileReader("e:/others/db.properties"));
		System.out.println(pro.getProperty("user","bjxst"));
	}
}
