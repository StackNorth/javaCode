import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;


public class TankClient extends Frame{
	public static final int GAME_WITDH = 800;
	public static final int GAME_HEIGTH =600;
	public static final int speed=20;
	private int x=50;
	private int y=50;
	Image offScreenImage = null;
	

	public void paint(Graphics g) {
		Color c =g.getColor();
		g.setColor(Color.RED);
		g.fillOval(x, y, 30, 30);//画实心圆
		g.setColor(c);
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
		this.setLocation(400, 300);
		this.setSize(GAME_WITDH, GAME_HEIGTH); 
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

		public void keyPressed(KeyEvent e) {			
			int key =e.getKeyCode();
			switch(key){
			case KeyEvent.VK_RIGHT:
				x+=speed;break;
			case KeyEvent.VK_LEFT:
				x-=speed;break;
			case KeyEvent.VK_UP:
				y-=speed;break;
			case KeyEvent.VK_DOWN:
				y+=speed;break;
			}
		}

	}
}
