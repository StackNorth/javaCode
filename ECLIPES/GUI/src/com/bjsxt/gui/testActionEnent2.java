package com.bjsxt.gui;

import java.awt.Button;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class testActionEnent2 {
	public static void main(String[] args) {
		Frame f= new Frame("Test");
		Button b1= new Button("start");
		Button b2 = new Button("stop");
		Monitor2 bh= new Monitor2();
		b1.addActionListener(bh);
		b2.addActionListener(bh);
		b2.setActionCommand("game over");
		f.add(b1,"North");
		f.add(b2,"Center");
		f.pack();
		f.setVisible(true);
	}
}
class Monitor2 implements ActionListener{
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		System.out.println("a button has been pressed!"+"the relative info is\n"+e.getActionCommand());
	}
		
	
}