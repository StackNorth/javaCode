import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Bullet {
	private int x;
	private int y;
	public static final int XSPEED=10;
	public static final int YSPEED=10;
	public static final int WIDTH =10;
	public static final int HEIGHT =10;
	private boolean live = true;
	Tank.Direction dir;
	TankClient tc;
	public Bullet(int x, int y,Tank.Direction dir) {
		this.x = x;
		this.y = y;
		this.dir = dir;
	}
	public Bullet(int x, int y,Tank.Direction dir, TankClient tc){
		this(x, y, dir);
		this.tc = tc;
		
	}
	public boolean isLive() {
		return live;
	}
	public void draw(Graphics g){
		if(!live){
			tc.Bullets.remove(this);
			return ;
		}
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
		
		if(x < 0 || y < 0 || x > TankClient.GAME_HEIGTH || y > TankClient.GAME_WITDH){
			live = false;
	
		}
	}
	
	public Rectangle getRec(){
		return new Rectangle(x,y,WIDTH,HEIGHT);
	}
	public boolean hitTank(Tank t){
		if(t.getRec().intersects(this.getRec())  && t.isLive()){
			t.setLive(false);
			this.live = false;
			return true;
		}
		return false;
	}
}
