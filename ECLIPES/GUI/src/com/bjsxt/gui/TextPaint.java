package com.bjsxt.gui;

import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;
/**
 * »­Í¼·½·¨paint
 * @author llf
 *
 */
public class TextPaint {
	public static void main(String[] args) {
		
		new PaintFrame().lunchFrame();
	}
}
class PaintFrame extends Frame{
	public PaintFrame(){
		super("»­Í¼");
		
	}
	public void lunchFrame(){	
		setBounds(200,200, 800, 800);
		setVisible(true);
	}
	public void paint(Graphics g){
		Color c = g.getColor();
		g.setColor(Color.blue);
		g.drawLine(100, 100, 200, 200);
		g.setColor(Color.black);
		g.drawArc(200, 200, 10, 10,10, 180);
		g.setColor(Color.red);
		g.fillOval(20, 20, 30, 30);
		g.setColor(Color.GREEN);
		g.fillRect(80, 80, 40, 40);
		g.setColor(c);
	}
}
