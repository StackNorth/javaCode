import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;


public class Tank {
	public static final int XSPEED=5;
	public static final int YSPEED=5;
	public static final int WIDTH =30;
	public static final int HEIGHT =30;
	private int x;
	private int y;
	private boolean live = true;
	private boolean U=false;
	private boolean D=false;
	private boolean L=false;
	private boolean R=false;
	Color tankColor=Color.RED;
	enum Direction {U,LU,R,RU,D,RD,L,LD,STOP};
	Direction d = Direction.STOP;
	TankClient tc = null;
	Direction ptDir =Direction.R;
	public Tank(int x, int y) {
		this.x = x;
		this.y = y;
	}
	public Tank(int x, int y,TankClient ct) {
		this(x,y);
		this.tc  = ct;
	}
	public Tank(int x, int y,TankClient ct,Color tankColor) {
		this(x,y);
		this.tc  = ct;
		this.tankColor = tankColor;
	}
	
	public boolean isLive() {
		return live;
	}
	public void setLive(boolean live) {
		this.live = live;
	}
	public void draw(Graphics g){
		if(!live) return ;
		Color c =g.getColor();
		g.setColor(tankColor);
		g.fillOval(x, y, WIDTH, HEIGHT);//��ʵ��Բ
		g.setColor(c);
		/**
		 * ��Ͳ��λ��
		 */
		switch(ptDir){
		case L:
			g.drawLine(x+Tank.WIDTH/2, y+Tank.HEIGHT/2, x, y+Tank.HEIGHT/2);
			break;
		case LU:
			g.drawLine(x+Tank.WIDTH/2, y+Tank.HEIGHT/2, x, y);
			break;
		case U:
			g.drawLine(x+Tank.WIDTH/2, y+Tank.HEIGHT/2, x+Tank.WIDTH/2, y);
			break;
		case RU:
			g.drawLine(x+Tank.WIDTH/2, y+Tank.HEIGHT/2, x+Tank.WIDTH, y);
			break;
		case R:
			g.drawLine(x+Tank.WIDTH/2, y+Tank.HEIGHT/2, x+Tank.WIDTH, y+Tank.HEIGHT/2);
			break;
		case RD:
			g.drawLine(x+Tank.WIDTH/2, y+Tank.HEIGHT/2, x+Tank.WIDTH, y+Tank.HEIGHT);
			break;
		case D:
			g.drawLine(x+Tank.WIDTH/2, y+Tank.HEIGHT/2, x+Tank.WIDTH/2, y+Tank.HEIGHT);
			break;
		case LD:
			g.drawLine(x+Tank.WIDTH/2, y+Tank.HEIGHT/2, x, y+Tank.HEIGHT);
			break;
		}
		move();
	}
	public void move(){
		switch(d){
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
		case STOP:
			break;	
		}
		if(this.d != Direction.STOP){
			this.ptDir = this.d;
			
		}
		if(x < 0) x=0;
		if(y < 30) y=30;
		if(x+Tank.WIDTH > TankClient.GAME_WITDH) x = TankClient.GAME_WITDH - Tank.WIDTH;
		if(y+Tank.HEIGHT > TankClient.GAME_HEIGTH) y = TankClient.GAME_HEIGTH-Tank.HEIGHT;
		 
	}
	public void keyPressed(KeyEvent e){
		int key =e.getKeyCode();
		switch(key){
		
		case KeyEvent.VK_RIGHT:
			R = true;break;
		case KeyEvent.VK_LEFT:
			L = true;break;
		case KeyEvent.VK_UP:
			U = true;break;
		case KeyEvent.VK_DOWN:
			D = true;break;
		}
		locateDirection();
	}
	public void fire() {
		int x = this.x+Tank.WIDTH/2 -Bullet.WIDTH/2;
		int y = this.y+Tank.HEIGHT/2 -Bullet.HEIGHT/2;
		Bullet b = new Bullet(x,y,ptDir,this.tc);
		tc.Bullets.add(b);
	
	}
	public void locateDirection() {
		if(R && !L && !U && !D) d=Direction.R;
		else if(R && !L && U && !D) d=Direction.RU;
		else if(!R && !L && U && !D) d=Direction.U;
		else if(!R && L && U && !D) d=Direction.LU;
		else if(!R && !L && !U && D) d=Direction.D;
		else if(R && !L && !U && D) d=Direction.RD;
		else if(!R && L && !U && !D) d=Direction.L;
		else if(!R && L && !U && D) d=Direction.LD;
		else if(!R && !L && !U && !D) d=Direction.STOP;
	}
	public void keyReleased(KeyEvent e) {
		int key =e.getKeyCode();
		switch(key){
		case KeyEvent.VK_CONTROL:
			fire();break;
		case KeyEvent.VK_RIGHT:
			R = false;break;
		case KeyEvent.VK_LEFT:
			L = false;break;
		case KeyEvent.VK_UP:
			U = false;break;
		case KeyEvent.VK_DOWN:
			D = false;break;
		}
		locateDirection();	
	}
	public Rectangle getRec(){
		return new Rectangle(x,y,WIDTH,HEIGHT);
	}
}
