package cn.bjsxt.others.pro;

import java.util.Properties;

/**
 * Properties��Դ�����ļ��Ķ�д
 * 1��key��valueֻ��Ϊ�ַ���
 * 2���洢���ȡ
 * @author llf
 *
 */
public class Demo01 {
	public static void main(String[] args) {
		//��������
		Properties pro = new Properties();
		//�洢
		pro.setProperty("driver", "oracle.jdbc.driver.OraclePriver");
		pro.setProperty("url", "jdbc:oracle:thin:@localhost12315:orcl");
		pro.setProperty("user", "scott");
		pro.setProperty("pud", "tiger");
		//��ȡ
		String url = pro.getProperty("url","test");//������ʹ�ã���������ʹ�ø�����ֵtest
		System.out.println(url);
	}
}
