package cn.bjxst.io.file;

import java.io.File;

/**
 * ��������
 * 1·���ָ���;
 * 2���Ʒָ���\(windows)/(��windows)
 * 
 * @author llf
 *
 */
public class Demo01 {
	public static void main(String[] args) {
		System.out.println(File.pathSeparator);
		System.out.println(File.separator);
		//·����ʾ��ʽ
		String path="E:\\java\\����";//���Ƽ�
		path ="E"+File.separator+"java"+File.separator+"����";//���Ƽ�
		path="E:/java/����";//�Ƽ�ʹ��
	}
}
