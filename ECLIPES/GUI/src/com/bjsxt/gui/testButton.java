package com.bjsxt.gui;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Panel;

public class testButton {
	public static void main(String[] args) {
		Frame f= new Frame("test Button");
		f.setLayout(new GridLayout(2,1));//设置两行一列
		f.setLocation(300,400);//设置位置
		f.setSize(300,200);//设置大小
		f.setBackground(new Color(204,204,255));
		Panel p1 = new Panel(new BorderLayout());
		Panel p2 = new Panel(new BorderLayout());
		Panel p11 = new Panel(new GridLayout(2,1));
		Panel p21 = new Panel(new GridLayout(2,2));
		p1.add(new Button("BUtton"),BorderLayout.WEST);
		p1.add(new Button("BUtton"),BorderLayout.EAST);
		p11.add(new Button("BUtton"));
		p11.add(new Button("BUtton"));
		p1.add(p11,BorderLayout.CENTER);
		p2.add(new Button("BUtton"),BorderLayout.WEST);
		p2.add(new Button("BUtton"),BorderLayout.EAST);
		for(int i=0;i<4;i++) p21.add(new Button("BUtton"));

		p2.add(p21,BorderLayout.CENTER);
		f.add(p1);f.add(p2);
		f.setVisible(true);//设置可见性
		
	}
}
