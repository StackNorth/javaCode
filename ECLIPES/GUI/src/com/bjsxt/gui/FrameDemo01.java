package com.bjsxt.gui;

import java.awt.Color;
import java.awt.Frame;
/**
 * ����һ���µĴ���
 * @author llf
 *
 */
public class FrameDemo01 {
	public static void main(String[] args) {
		Frame f = new Frame("my frist test");//����һ�����ں�����
		f.setBackground(Color.black);//���ô��ڵı�����ɫ
		f.setLocation(0,0);//���ô���λ��
		f.setSize(170, 200);//���ô��ڴ�С
		f.setResizable(false);//�����Ƿ�ɵ��ڴ�С
		f.setVisible(true);//�����Ƿ�ɼ�
	}
}
