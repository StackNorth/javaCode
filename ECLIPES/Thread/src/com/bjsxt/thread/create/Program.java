package com.bjsxt.thread.create;
/**1�Ƽ�ʹ��Runnable�����߳�
 *  1�����ⵥ�̳еľ�����
 *  2�����ڹ�����Դ
 * ʹ��Runnable�����߳� 
 * 1����ʵ��Runnable�ӿ�+��дrun()-->��ʵ��ɫ��
 * 2���������߳� ʹ�þ�̬����
 * //������ʵ��ɫ
 * //���������ɫ+��ʵ��ɫ������
 * //���÷����������߳�
 * @author llf
 *
 */
public class Program implements Runnable {

	@Override
	public void run() {
		for(int i=0;i<100;i++){
			System.out.println("һ���ô���"+i);
			
		}
	}
	
}
