package com.bjsxt.gui;
import java.awt.Frame;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



public class TextActionEvent {
	public static void main(String[] args) {
		new TFFrame();
	}
}
class TFFrame extends Frame{
	TFFrame(){
		TextField tf = new TextField();
		add(tf);
		tf.addActionListener(new TFActionListener());
		//tf.setEchoChar('*');������ʾ*��
		pack();
		setVisible(true);
		
	}
	
}
class TFActionListener implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent e) {
		TextField tf = (TextField)e.getSource();//������һ���¼�Դ����
		System.out.println(tf.getText());
		tf.setText(null);
		
	}
	
	
}
