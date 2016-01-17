package com.bjsxt.gui.mouse;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Frame;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class TextAnonyMouse {
	Frame f= new Frame("text");
	Button b= new Button("Start");
	TextField tf= new TextField(5);
	public TextAnonyMouse() {
		f.add(b,BorderLayout.NORTH);
		f.add(tf,BorderLayout.CENTER);
		b.addActionListener(new ActionListener() {			
			private int i=0;
			public void actionPerformed(ActionEvent e) {
				tf.setText(e.getActionCommand()+ ++i);
			}
		});
		f.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e){
			f.setVisible(false);
			System.exit(0);	
			}
		});
		f.setVisible(true);
		f.pack();
	}
	public static void main(String[] args) {
		new TextAnonyMouse();
	}
}
