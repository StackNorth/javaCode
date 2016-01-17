package com.bjsxt.gui;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

public class testActionEvent {
	public static void main(String[] args) {
		JFrame f= new JFrame("Test");
		Button b = new Button("press me!");
		Monitor bh = new Monitor();
		b.addActionListener(bh);
		f.add(b,BorderLayout.CENTER);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.pack();
		f.setVisible(true);
	}
}
class Monitor implements ActionListener{
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		System.out.println("a button has been pressed!");
	}
		
	
}
