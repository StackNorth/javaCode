package cn.bjsxt.others.pro;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * ʹ��Properties������ļ�
 * �ֽ���Դ�����ļ���
 * @author llf
 *�洢����
 *.Properties
 *1��store(OutputStream out,String comments) 
 2��store(Writer writer, String comments) 
 *.XML
 storeToXML(OutputStream os, String comment)UTF-8�ַ���
storeToXML(OutputStream os, String comment, String encoding) 
 */
public class Demo02 {
	public static void main(String[] args) throws FileNotFoundException, IOException {
		//��������
		Properties pro = new Properties();
		//�洢
		pro.setProperty("driver", "oracle.jdbc.driver.OraclePriver");
		pro.setProperty("url", "jdbc:oracle:thin:@localhost12315:orcl");				pro.setProperty("user", "scott");
		pro.setProperty("pud", "tiger");
		//�洢��e��/others ����·��		
		pro.store(new FileOutputStream(new File("e:/others/db.properties")), "db����");		
		pro.store(new FileOutputStream(new File("e:/others/db.xml")), "db����");		
	//���·��
		pro.store(new FileOutputStream(new File("cn/bjsxt/others/pro/db.properties")), "db����");		
		
				
				
				
				
	}
}
