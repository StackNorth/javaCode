import java.awt.Color;
import java.awt.Graphics;


public class Explode {
	private int x;
	private int y;
	private int[] diameter ={4,7,12,24,32,48,30,20,7};
	private int step = 0;
	TankClient tc;
	private boolean live = true;
	
	public Explode(int x, int y, TankClient tc) {
		this.x = x;
		this.y = y;
		this.tc = tc;
	}

	public void draw(Graphics g){
		if(!live){
			tc.explodes.remove(this);
			return;
		}
		if(step == diameter.length){
			step =0;
			live = false;
			return;
		}
		Color c = g.getColor();
		g.setColor(Color.ORANGE);
		g.fillOval(x, y, diameter[step], diameter[step]);
		step++;
		g.setColor(c);
	}
}
