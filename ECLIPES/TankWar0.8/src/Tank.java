import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;


public class Tank {
	public static final int XSPEED=20;
	public static final int YSPEED=20;
	private int x;
	private int y;
	private boolean U=false;
	private boolean D=false;
	private boolean L=false;
	private boolean R=false;
	enum direction {U,LU,R,RU,D,RD,L,LD,STOP};
	direction d = direction.STOP;
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
		case STOP:break;	
		}
		
	}
	public void KeyPressed(KeyEvent e){
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
		if(R && !L && !U && !D) d=direction.R;
		if(R && !L && U && !D) d=direction.RU;
		if(!R && !L && U && !D) d=direction.U;
		if(!R && L && U && !D) d=direction.LU;
		if(!R && !L && !U && D) d=direction.D;
		if(R && !L && !U && D) d=direction.RD;
		if(!R && L && !U && !D) d=direction.L;
		if(!R && L && !U && D) d=direction.LD;
		if(!R && !L && !U && !D) d=direction.STOP;
	}
}
