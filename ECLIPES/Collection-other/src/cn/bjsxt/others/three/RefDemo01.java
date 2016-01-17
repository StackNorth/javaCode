package cn.bjsxt.others.three;

import java.lang.ref.WeakReference;

/**
 * ���õķ��ࣺǿ����������
 * ֻ��ǿ��������
 * @author llf
 *
 */
public class RefDemo01 {
	public static void main(String[] args) {
		//�ַ���������  
				String str = new String("bjxst is very good!");
				//�����ù������
				WeakReference<String> wr = new WeakReference<String>(str);
				System.out.println("gc����ǰ��"+wr.get());
				//�Ͽ�����
				str=null;
				//֪ͨ����
				System.gc();
				System.runFinalization();
				System.out.println("gc���к�"+wr.get());
				
	}
	
	public static void testString(){
		//�ַ���������  �������ܻ��գ�
				String str = "bjxst is very good!";
				//�����ù������
				WeakReference<String> wr = new WeakReference<String>(str);
				System.out.println("gc����ǰ��"+wr.get());
				//�Ͽ�����
				str=null;
				//֪ͨ����
				System.gc();
				System.runFinalization();
				System.out.println("gc���к�"+wr.get());

		
	}
}
