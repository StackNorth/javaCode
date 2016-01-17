import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;


public class TankClient extends Frame{
	public static final int GAME_WITDH = 1000;
	public static final int GAME_HEIGTH = 800;
	Image offScreenImage = null;
	Tank myTank = new Tank(400,500,this);
	Wall w1 = new Wall(300,200,20,150,this);
	Wall w2 = new Wall(400,100,150,20,this);
	List<Explode> explodes = new ArrayList<Explode>();
	List<Bullet> Bullets = new ArrayList<Bullet>();
	List<Tank> tanks = new ArrayList<Tank>();
	public void paint(Graphics g) {
		g.drawString("Bullets Count:"+Bullets.size(), 50, 60);
		g.drawString("Explodes Count:"+explodes.size(), 50, 80);
		g.drawString("Tanks Count:"+tanks.size(), 50, 100);
		if(!myTank.isLive()){
			g.drawString("GAME OVER！！",300,400);
			
		}
		//此处不能使用增强for循环遍历
		for(int i=0;i<Bullets.size();i++){
			Bullet b = Bullets.get(i);
		//	b.hitTank(otherTank);	
			b.draw(g);
			b.hitWall(w1);
			b.hitWall(w2);
			b.hitTanks(tanks);
			b.hitTank(myTank);
		}
		for(int i=0;i<explodes.size();i++){	
			Explode e = explodes.get(i);
			e.draw(g);
		}
		for(int i=0;i<tanks.size();i++){	
			Tank t = tanks.get(i);
			t.collidesWithWall(w1);
			t.collidesWithWall(w2);
			t.collidesWithTanks(tanks);
			t.draw(g);
		}
		
		w1.draw(g);
		w2.draw(g);
		//otherTank.draw(g);
		myTank.draw(g);//myTank由keyPressed检测控制
		myTank.collidesWithWall(w1);
		myTank.collidesWithWall(w2);
	}
	/**
	 * 双缓冲技术是利用两幅图片进行显示
	 */
	public void update(Graphics g) {
		if(offScreenImage ==null){
			offScreenImage = this.createImage(GAME_WITDH, GAME_HEIGTH);
		}
		Graphics gOffScreen = offScreenImage.getGraphics();//在屏幕外画出一副图像，用于双缓冲
		Color c =gOffScreen.getColor();
		gOffScreen.setColor(Color.GREEN);
		gOffScreen.fillRect(0, 0, GAME_WITDH, GAME_HEIGTH);
		gOffScreen.setColor(c); 
		paint(gOffScreen);
		g.drawImage(offScreenImage, 0, 0, null);
	}
	
	public void lunchFrame(){
		//将坦克加入容器中
		if(tanks.size() == 0){
			for(int i=0;i<10;i++){
				tanks.add(new Tank(50+40*i,50,this,false,Tank.Direction.D));
				
			}
		}
		setLocation(40, 30);
		this.setSize(GAME_WITDH, GAME_HEIGTH); 
		this.setResizable(false);
		this.addWindowListener(new WindowAdapter() {

			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		
		});
		this.setBackground(Color.GREEN);
		this.setVisible(true);
		this.addKeyListener(new KeyMonitor());
		new Thread(new PaintThread()).start();  
	}
	
	
	public static void main(String[] args) {
		TankClient tc = new TankClient();
		tc.lunchFrame();
	}
	private class PaintThread implements Runnable{

		public void run() {
			while(true){
				repaint();
				try {
					Thread.sleep(50);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			
		}
		
		
	}
	private class KeyMonitor extends KeyAdapter{

		public void keyReleased(KeyEvent e) {
			myTank.keyReleased(e);
		}

		public void keyPressed(KeyEvent e) {
			myTank.keyPressed(e);
		}
		
	}
}
