import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.util.Random;


public class Tank {
	 int ID;
	public static final int XSPEED=5;
	public static final int YSPEED=5;
	public static final int WIDTH =30;
	public static final int HEIGHT =30;
	private int x;
	private int y;
	private int step = r.nextInt(12)+3;
	private boolean live = true;
	private boolean U=false;
	private boolean D=false;
	private boolean L=false;
	private boolean R=false;
	private static Random r= new Random();
	Dir d = Dir.STOP;
	TankClient tc = null;
	Dir ptDir =Dir.R;
	private boolean good = true;
	public Tank(int x, int y) {
		this.x = x;
		this.y = y;
	}
	public Tank(int x, int y,TankClient tc) {
		this(x,y);
		this.tc  = tc;
	}
	
	public Tank(int x, int y,TankClient tc,boolean good,Dir d) {
		this(x,y,tc);
		this.d = d;
		this.good  = good;
	}
	
	public boolean isLive() {
		return live;
	}
	public void setLive(boolean live) {
		this.live = live;
	}
	public void draw(Graphics g){
		if(!live) {
			/*if(!good){
				tc.tanks.remove(this);
			}*/
			return ;
			}
		Color c =g.getColor();
		if(good){
		g.setColor(Color.RED);
		}else{
			g.setColor(Color.BLUE);	
		}
		g.fillOval(x, y, WIDTH, HEIGHT);//画实心圆
		g.setColor(c);
		/**
		 * 炮筒的位置
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
		if(this.d != Dir.STOP){
			this.ptDir = this.d;
			
		}
		if(x < 0) x=0;
		if(y < 30) y=30;
		if(x+Tank.WIDTH > TankClient.GAME_WITDH) x = TankClient.GAME_WITDH - Tank.WIDTH;
		if(y+Tank.HEIGHT > TankClient.GAME_HEIGTH) y = TankClient.GAME_HEIGTH-Tank.HEIGHT;
		 if(!good){
			 Dir[] dirs = d.values();
			 if(step ==0){
				 step = r.nextInt(20)+3;
				 int rn = r.nextInt(dirs.length);
				 d = dirs[rn]; 
			 }
			 step--;
			 if(r.nextInt(40)>38){
				 this.fire();
			 }
		 }
	}
	public boolean isGood() {
		return good;
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
	public Bullet fire() {
		if(!live) return null;
		int x = this.x+Tank.WIDTH/2 -Bullet.WIDTH/2;
		int y = this.y+Tank.HEIGHT/2 -Bullet.HEIGHT/2;
		Bullet b = new Bullet(x,y,ptDir,this.tc,good);
		tc.Bullets.add(b);
		return b;	
	}
	public void locateDirection() {
		if(R && !L && !U && !D) d=Dir.R;
		else if(R && !L && U && !D) d=Dir.RU;
		else if(!R && !L && U && !D) d=Dir.U;
		else if(!R && L && U && !D) d=Dir.LU;
		else if(!R && !L && !U && D) d=Dir.D;
		else if(R && !L && !U && D) d=Dir.RD;
		else if(!R && L && !U && !D) d=Dir.L;
		else if(!R && L && !U && D) d=Dir.LD;
		else if(!R && !L && !U && !D) d=Dir.STOP;
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
