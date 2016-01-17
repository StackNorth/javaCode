package cn.bjsxt.test;

import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * 测试窗口物体沿着轨道运动
 * @author llf
 *
 */
public class GameFrame03 extends MyFrame {//GUI:AWT,swing等实现窗口
	Image img = GameUtil.getImage("images/sun.jpg");

	
	
	private double x=100 ,y=100;
	private double degree = 3.14/3;
	private double speed = 10;
	@Override
	public void paint(Graphics g) {
		
		g.drawImage(img, (int)x, (int)y,null);
		if(speed>0){
			speed -= 0.02;
		}else{
			speed = 0;
		}
		x += speed*Math.cos(degree);
		y += speed*Math.sin(degree);
		
		if(y>500-30 || y<30){
			degree = -degree;
		}
		if(x<30 || x>500-30){
			degree = Math.PI-degree;
		}
		 
	}
	
	public static void main(String[] args) {
		GameFrame03 gf = new GameFrame03();
		gf.launchFrame();
	}

}
