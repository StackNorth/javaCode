import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;


public class Tank {
	public static final int XSPEED=5;
	public static final int YSPEED=5;
	private int x;
	private int y;
	private boolean U=false;
	private boolean D=false;
	private boolean L=false;
	private boolean R=false;
	enum Direction {U,LU,R,RU,D,RD,L,LD,STOP};
	Direction d = Direction.STOP;
	public Tank(int x, int y) {
		this.x = x;
		this.y = y;
	}
	public void draw(Graphics g){
		Color c =g.getColor();
		g.setColor(Color.RED);
		g.fillOval(x, y, 30, 30);//»­ÊµÐÄÔ²
		g.setColor(c);
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
	
}
