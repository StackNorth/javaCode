package cn.bjsxt.solar;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;

import cn.bjsxt.util.GameUtil;

/**
 * @author llf
 *
 */
public class Planet extends Star {
	
//	  行星沿着某个椭圆运行，：长轴，短轴，速度、角度。绕着某个Star飞
	double longAxis;//椭圆的长轴
	double shortAxis;//椭圆的短轴
	double speed;//速度
	double degree;//角度 
	Star center;//中心
	boolean satellite;
	
	public void draw(Graphics g){
		super.draw(g);
		move();
		if(!satellite){
			drawTrace(g);
		}
	}
	
	public void drawTrace(Graphics g){
		double ovalX,ovalY,ovalWidth,ovalHeight;
		ovalWidth = longAxis*2;
		ovalHeight = shortAxis*2;
		ovalX = (center.x + center.width/2) - longAxis;
		ovalY = (center.y + center.height/2) - shortAxis;
	
		
		Color c = g.getColor();
		g.setColor(Color.blue);
		g.drawOval((int)ovalX,(int)ovalY,(int)ovalWidth, (int)ovalHeight);
		g.setColor(c);
	}
	
	public void move() {
		x = (center.x + center.width/2)+ longAxis*Math.cos(degree);
		y = (center.y + center.height/2)+ shortAxis*Math.sin(degree);
		degree += speed;
		
	}

	public Planet(Star center, String imgpath, double longAxis,double shortAxis, double speed) {
		super(GameUtil.getImage(imgpath));
		this.center = center;
		this.x = center.x + longAxis;
		this.y = center.y;
		this.longAxis = longAxis;
		this.shortAxis = shortAxis;
		this.speed = speed;
		
		this.width = img.getWidth(null);
		this.height = img.getHeight(null);
		
	}
	
	public Planet(Star center, String imgpath, double longAxis,double shortAxis, double speed, boolean satellite) {
		this(center,imgpath,longAxis,shortAxis,speed);
		this.satellite = satellite; 
	}
	
	public Planet(Image img, double x, double y) {
		super(img, x, y);
	}
	public Planet(String imgpath, double x, double y) {
		super(imgpath, x, y);
	}
	
}
