package cn.bjxst.io.charIO;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

/**
 * �ļ�д��
 * @author llf
 *
 */
public class Demo02 {
	public static void main(String[] args) {
		//����Դ
		File dest=new File("E:/Java/abc.txt");
		//ѡ����
		Writer wr=null;
		try {
			wr=new FileWriter(dest,true);
			String str="�����յ���\n����������\n";
			wr.write(str);
			wr.append("�ط���������");
			wr.flush();
		} catch (IOException e) {
			System.out.println("Դ�ļ�д��ʧ��");
			e.printStackTrace();
		}finally{
			if(null==wr){
				
				try {
					wr.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			
		}
	}
}
