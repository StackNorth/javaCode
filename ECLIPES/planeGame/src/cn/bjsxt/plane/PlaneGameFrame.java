package cn.bjsxt.plane;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.peer.SystemTrayPeer;
import java.util.ArrayList;
import java.util.Date;

import cn.bjsxt.Util.GameUtil;
import cn.bjsxt.Util.MyFrame;

public class PlaneGameFrame extends MyFrame{

		
	Image bg = GameUtil.getImage("images/bj.jpg");
	Plane p = new Plane("images/plane.png",50,50);
	ArrayList bulletList = new ArrayList();//泛型暂时为学
	
	Date startTime;	
	Date endTime;
	Explore bao;

	public static void main(String[] args) {
		new PlaneGameFrame().launchFrame();
	}
	
	public void paint(Graphics g){
		g.drawImage(bg,0,0,null);
		p.draw(g);
	
		for(int i=0;i<bulletList.size();i++){
			Bullet b = (Bullet)bulletList.get(i);
			b.draw(g);
			
			boolean peng =	b.getRect().intersects(p.getRect());
			if(peng){
				p.setLive(false);
				if(bao == null){
					endTime = new Date();
					 bao = new Explore(p.x,p.y); 
				}
				bao.draw(g); 
				break;
				
			}
			
		}
		/*if(p.isLive()){
			printInfo(g,"Time:" + d.getTime()/1000 + "s",20,120,350,Color.white); 
			
		}
		*/
		if(!p.isLive()){
			long period =(endTime.getTime()-startTime.getTime())/1000;
			printInfo(g,"Time:" + period + "s",20,120,350,Color.white); 
			switch((int)period/10){
			case 0:
			case 1:	
				printInfo(g,"菜鸟",20,120,300,Color.white);
				break;
			case 2:
				printInfo(g,"小鸟",20,120,300,Color.white);
				break;
			case 3:
				printInfo(g,"大鸟",20,120,300,Color.white);
				break;
			case 4:
				printInfo(g,"老鸟",20,320,300,Color.white);
				break;
			default  :
				printInfo(g,"鸟人",20,120,300,Color.white);
				break;
			}
		
		}
//		printInfo(g,"分数：100",10,Color.yellow,10,50);
	}
	/**
	 * 在窗口上打印消息
	 * @param g
	 * @param str
	 * @param size
	 * @param color
	 * @param x
	 * @param y
	 */
	public void printInfo(Graphics g,String str,int size,int x,int y,Color color){
		Color c = g.getColor();
		g.setColor(color);
		Font f = new Font("宋体",Font.BOLD,size);
		g.setFont(f);
		g.drawString(str,x,y);
		g.setColor(c);
	}
	
	
	public void launchFrame(){
		super.launchFrame();//调取父类的方法
		addKeyListener(new KeyMonitor());
		for(int i = 0;i < 10;i++){
			 Bullet b = new Bullet();
			 bulletList.add(b);
		}
		startTime = new Date();
		
	}
	
	
	class KeyMonitor extends KeyAdapter{
		public void keyPressed(KeyEvent e) {
			p.addDirection(e);
		}

		@Override
		public void keyReleased(KeyEvent e) {
			p.reduceDirection(e);
		}
		
	}
	
}



