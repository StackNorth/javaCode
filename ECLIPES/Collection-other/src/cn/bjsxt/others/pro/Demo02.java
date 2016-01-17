package cn.bjsxt.others.pro;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * 使用Properties输出到文件
 * 又叫资源配置文件；
 * @author llf
 *存储方法
 *.Properties
 *1、store(OutputStream out,String comments) 
 2、store(Writer writer, String comments) 
 *.XML
 storeToXML(OutputStream os, String comment)UTF-8字符集
storeToXML(OutputStream os, String comment, String encoding) 
 */
public class Demo02 {
	public static void main(String[] args) throws FileNotFoundException, IOException {
		//创建对象
		Properties pro = new Properties();
		//存储
		pro.setProperty("driver", "oracle.jdbc.driver.OraclePriver");
		pro.setProperty("url", "jdbc:oracle:thin:@localhost12315:orcl");				pro.setProperty("user", "scott");
		pro.setProperty("pud", "tiger");
		//存储的e：/others 绝对路径		
		pro.store(new FileOutputStream(new File("e:/others/db.properties")), "db配置");		
		pro.store(new FileOutputStream(new File("e:/others/db.xml")), "db配置");		
	//相对路径
		pro.store(new FileOutputStream(new File("cn/bjsxt/others/pro/db.properties")), "db配置");		
		
				
				
				
				
	}
}
