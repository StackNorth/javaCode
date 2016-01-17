package cn.bjsxt.others.pro;

import java.util.Properties;

/**
 * Properties资源配置文件的读写
 * 1、key与value只能为字符串
 * 2、存储与读取
 * @author llf
 *
 */
public class Demo01 {
	public static void main(String[] args) {
		//创建对象
		Properties pro = new Properties();
		//存储
		pro.setProperty("driver", "oracle.jdbc.driver.OraclePriver");
		pro.setProperty("url", "jdbc:oracle:thin:@localhost12315:orcl");
		pro.setProperty("user", "scott");
		pro.setProperty("pud", "tiger");
		//获取
		String url = pro.getProperty("url","test");//存在则使用，不存在则使用给定的值test
		System.out.println(url);
	}
}
