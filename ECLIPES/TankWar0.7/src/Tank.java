import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;


public class Tank {
	public static final int speed=20;

	private int x;
	private int y;

	public Tank(int x, int y) {
		this.x = x;
		this.y = y;
	}
	public void draw(Graphics g){
		Color c =g.getColor();
		g.setColor(Color.RED);
		g.fillOval(x, y, 30, 30);//»­ÊµÐÄÔ²
		g.setColor(c);
	}
	public void keyPressed(KeyEvent e){
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
