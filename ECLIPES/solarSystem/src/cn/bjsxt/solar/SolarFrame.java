package cn.bjsxt.solar;

import java.awt.Graphics;
import java.awt.Image;

import cn.bjsxt.util.Constant;
import cn.bjsxt.util.GameUtil;
import cn.bjsxt.util.MyFrame;

/**
 * 太阳系的主窗口
 * @author llf
 *
 */
public class SolarFrame extends MyFrame{
		Image bj = GameUtil.getImage("images/bj.jpg");
		Star sun = new Star("images/sun.jpg",Constant.GAME_HEIGHT/2,Constant.GAME_WIDTH/2);
		Planet earth = new Planet(sun,"images/earth.jpg", 150, 100, 0.1);
		Planet mars = new Planet(sun,"images/earth.jpg", 200, 200, 0.2);
		Planet  mercury= new Planet(sun,"images/earth.jpg", 300, 250, 0.4);
		Planet moon = new Planet(earth,"images/earth.jpg", 30, 20, 0.3,true);
		public void paint(Graphics g){
			g.drawImage(bj, 0, 0,null);
			sun.draw(g);
			earth.draw(g);
			mars.draw(g);
			moon.draw(g);
			mercury.draw(g);
		}
		
		
		public static void main(String[] args) {
			new SolarFrame().launchFrame();
		}
}
