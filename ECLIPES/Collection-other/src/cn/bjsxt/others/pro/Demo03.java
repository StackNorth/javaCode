package cn.bjsxt.others.pro;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

/**
 * ʹ��properties��ȡ�����ļ�
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
		//��ȡ����·��
		pro.load(new FileReader("e:/others/db.properties"));
		System.out.println(pro.getProperty("user","bjxst"));
	}
}
