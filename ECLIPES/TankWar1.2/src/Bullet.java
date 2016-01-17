import java.awt.Color;
import java.awt.Graphics;

public class Bullet {
	private int x;
	private int y;
	public static final int XSPEED=10;
	public static final int YSPEED=10;
	public static final int WIDTH =10;
	public static final int HEIGHT =10;
	Tank.Direction dir;
	public Bullet(int x, int y,Tank.Direction dir) {
		this.x = x;
		this.y = y;
		this.dir = dir;
	}
	public void draw(Graphics g){
		Color c =g.getColor();
		g.setColor(Color.BLACK);
		g.fillOval(x, y, WIDTH, HEIGHT);//»­ÊµÐÄÔ²
		g.setColor(c);	
		move();
	}
	private void move() {
		switch(dir){
		case U:
			y -= YSPEED;
			break;
		case LU:
			x -= XSPEED;
			y -= YSPEED;
			break;
		case R:
			x += XSPEED;
			break;
		case RU:
			x += XSPEED;
			y -= YSPEED;
			break;
		case D:
			y += YSPEED;
			break;
		case RD:
			y += YSPEED;
			x += XSPEED;
			break;
		case L:
			x -= XSPEED;
			break;
		case LD:
			x -= XSPEED;
			y += YSPEED;
			break;
		case STOP:break;	
		}
	}
}
