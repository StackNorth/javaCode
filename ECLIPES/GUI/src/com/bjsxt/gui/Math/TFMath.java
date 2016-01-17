package com.bjsxt.gui.Math;

import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TFMath {
	public static void main(String[] args) {
			TFFrame tf = new TFFrame();
			tf.launchFrame();
	}
}
class TFFrame extends Frame{
	TextField num1,num2,num3;
	void launchFrame(){
		num1 = new TextField(10);
		num2 = new TextField(10);
		num3 = new TextField(15);
		Label lbAdd = new Label("+");
		Button btEquals = new Button("=");
		btEquals.addActionListener(new MyMonitor());
		setLayout(new FlowLayout());
		add(num1);
		add(lbAdd);
		add(num2);
		add(btEquals);
		add(num3);
		setVisible(true);
		pack();
	}
	//内部类可以非常方便的访问外部类的成员和方法
	private class MyMonitor implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			int n1 =  Integer.parseInt(num1.getText());
			int n2 =  Integer.parseInt(num2.getText());
			num3.setText(""+(n1+n2));
		}
		
		
	}
}
//将mymonitor暴露出来，不安全
/*class MyMonitor implements ActionListener{
	TFFrame tf;
	MyMonitor(TFFrame tf){
		this.tf = tf;
	}
	public void actionPerformed(ActionEvent e) {
		int num1 =  Integer.parseInt(tf.num1.getText());
		int num2 =  Integer.parseInt(tf.num2.getText());
		tf.num3.setText(""+(num1+num2));
	}
	
	
}*/