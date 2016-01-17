package com.bjsxt.gui.mouse;

import java.awt.Frame;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class TestKey {
	public static void main(String[] args) {
		new	KeyFrame().lunchFrame();
	}
}
class KeyFrame extends Frame{
	public void lunchFrame(){
		setSize(200,300);
		setLocation(200,200);
		setVisible(true);
		addKeyListener(new  KeyAdapter(){//½Ó¿Ú
		public void keyPressed(KeyEvent e){
			int keyCode = e.getKeyCode();
			System.out.println(keyCode);
			/*if(keyCode == KeyEvent.VK_UP){
				System.out.println(keyCode);
			}*/
		}
		});
		
	}
	
}
