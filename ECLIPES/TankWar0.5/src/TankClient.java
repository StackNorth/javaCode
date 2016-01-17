import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;


public class TankClient extends Frame{
	public static final int GAME_WITDH = 800;
	public static final int GAME_HEIGTH =600;
	private int x=50;
	private int y=50;
	Image offScreenImage = null;
	

	public void paint(Graphics g) {
		Color c =g.getColor();
		g.setColor(Color.RED);
		g.fillOval(x, y, 30, 30);//画实心圆
		g.setColor(c);
		x+=5;
		y+=5;
	}
	
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
}
