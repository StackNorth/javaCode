package com.bjsxt.gui.mouse;

import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;



public class MyMouseApdate {
	public static void main(String[] args) {
		new MyFrame("MouseApdate");
	}
}
class MyFrame extends Frame{
	 ArrayList<Point> points=null;
	MyFrame(String s){
		super(s);
		points = new ArrayList<Point>();
		setLayout(null);
		setBounds(20, 20, 400, 400);//���ó�ʼλ�ã���С
		setVisible(true);//���ÿɼ�
		setBackground(new Color(255,255,204));//������ɫ
		this.addMouseListener(new Monitor());//��Ӽ�����
		this.addWindowListener(new MyWindowMonitor());//��Ӽ��������رմ���
		//������д��
		/*
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e){
				setVisible(false);
				System.exit(0);
			}
		});
			 
		 */
	}
	
	public void paint(Graphics s){
		Iterator<Point> i= points.iterator();//ʹ�õ�������������
		while(i.hasNext()){
			Point p = i.next();
			s.setColor(Color.BLUE);
			s.fillOval(p.x, p.y, 10, 10);//��Բ��λ�úʹ�С
		}
	}
	//��������ĵ����������
	public void addPaint(Point p){
		points.add(p);
	}
	//�������ڹر��¼�
	class MyWindowMonitor extends WindowAdapter{
		public void windowClosing(WindowEvent e){
			setVisible(false);
			System.exit(0);//0�����˳�1�������˳�   �����˳���������˳�Ч��һ��
			
		}
		
} 
//����¼�������
class Monitor extends MouseAdapter{
	public void mousePressed(MouseEvent e){
	MyFrame f= (MyFrame) e.getSource();
	f.addPaint(new Point(e.getX(),e.getY()));
	f.repaint();//repaint ����update��������update���뻭�ʵ���paint�������»�
	}
}	

}

