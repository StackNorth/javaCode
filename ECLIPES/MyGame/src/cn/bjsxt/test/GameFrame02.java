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
public class GameFrame02 extends MyFrame {//GUI:AWT,swing等实现窗口
	Image img = GameUtil.getImage("images/sun.jpg");
	

	
	private double x=100 ,y=100;
	private boolean left,up; 
	@Override
	public void paint(Graphics g) {
		
		g.drawImage(img, (int)x, (int)y,null);
		if(left){	
			x -= 10;
		}else{		
			x += 10;
		}
		if(x > 500-30){
			left = true;
		}
		if(x<0){
			left = false;
		}
		
		if(up){	
			y -= 10;
		}else{		
			y += 10;
		}
		if(y > 500-30){
			up = true;
		}
		if(y<0){
			up = false;
		}
		
		 
	}


	public static void main(String[] args) {
		GameFrame02 gf = new GameFrame02();
		gf.launchFrame();
	}

}
