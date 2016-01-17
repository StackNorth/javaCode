package com.bjsxt.gui;

import java.awt.Button;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Frame;

public class testFlowLayout2 {
	public static void main(String[] args) {
		Frame f= new Frame("new Frame");
		FlowLayout l = new FlowLayout(FlowLayout.CENTER,20,40);//布局管理器
		f.setLayout(l);
		f.setLocation(300,400);
		f.setSize(300,200);
		f.setBackground(new Color(204,204,255));
		for(int i=0;i<=7;i++){
			f.add(new Button("button"));
		}
		f.setVisible(true);
	}
}
