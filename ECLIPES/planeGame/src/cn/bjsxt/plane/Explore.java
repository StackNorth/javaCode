package cn.bjsxt.plane;

import java.awt.Graphics;
import java.awt.Image;

import cn.bjsxt.Util.GameUtil;

/**
 * ±¨’®¿‡
 * @author llf
 *
 */
public class Explore {
	double x,y;
	int count;
	static Image[] imgs = new Image[16];
	static{
		for(int i=0;i<16;i++){
			imgs[i] = GameUtil.getImage("images/explode/e"+(i+1)+".gif");
			imgs[i].getWidth(null);
		}
	}
	
	public void draw(Graphics g){
		if(count <= 15){
			g.drawImage(imgs[count],(int)x,(int)y,null);
			count++;
		}
			
			
	}
	public Explore(double x,double y){
		this.x = x;
		this.y = y;
	}
	
}
