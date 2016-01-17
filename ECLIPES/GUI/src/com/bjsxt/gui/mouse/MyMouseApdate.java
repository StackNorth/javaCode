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
		setBounds(20, 20, 400, 400);//设置初始位置，大小
		setVisible(true);//设置可见
		setBackground(new Color(255,255,204));//设置颜色
		this.addMouseListener(new Monitor());//添加监听器
		this.addWindowListener(new MyWindowMonitor());//添加监听器，关闭窗口
		//匿名类写法
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
		Iterator<Point> i= points.iterator();//使用迭代器遍历容器
		while(i.hasNext()){
			Point p = i.next();
			s.setColor(Color.BLUE);
			s.fillOval(p.x, p.y, 10, 10);//画圆的位置和大小
		}
	}
	//将鼠标点击的点加入容器中
	public void addPaint(Point p){
		points.add(p);
	}
	//监听窗口关闭事件
	class MyWindowMonitor extends WindowAdapter{
		public void windowClosing(WindowEvent e){
			setVisible(false);
			System.exit(0);//0正常退出1非正常退出   正常退出与非正常退出效果一样
			
		}
		
} 
//鼠标事件监听器
class Monitor extends MouseAdapter{
	public void mousePressed(MouseEvent e){
	MyFrame f= (MyFrame) e.getSource();
	f.addPaint(new Point(e.getX(),e.getY()));
	f.repaint();//repaint 调用update方法再由update传入画笔调用paint方法重新画
	}
}	

}

