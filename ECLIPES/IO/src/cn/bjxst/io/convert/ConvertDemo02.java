package cn.bjxst.io.convert;
import java.io.*;

/**
 * ת�������ֽ�תΪ�ַ�
 * 1���������OutputStreamWriter ����
 * 	   ��������InputStreamReader  ����
 * @author llf
 *
 */
public class ConvertDemo02 {
	public static void main(String[] args) throws IOException {
		//ָ��������ַ���
		BufferedReader rd= new BufferedReader(new InputStreamReader
				(new FileInputStream(new File("E:/Java/abc.txt")),"utf-8"));
		BufferedWriter rv=new BufferedWriter(new FileWriter("E:/Java/cde.java"));
		
		
		String info = null;
		while(null!=(info=rd.readLine())){
			rv.write(info);
			rv.newLine();
			
		}
		rv.flush();
		rv.close();//�ļ�д������رղ��ܽ���
		rd.close();
	}
}
