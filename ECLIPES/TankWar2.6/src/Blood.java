import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;


public class Blood {
	private int x;
	private int y;
	private int WIDTH =15;
	private int HEIGHT =15;
	private boolean live = true;
	private int[][] pos={{400,350},{400,400},{450,450},{500,500},{400,200},{400,250},{300,250}};
	private int step = 0;
	//TankClient tc =new TankClient();
	public Blood() {
		x = pos[0][0];
		y = pos[0][1];
	}
	
	public boolean isLive() {
		return live;
	}

	public void setLive(boolean live) {
		this.live = live;
	}

	public void draw(Graphics g){
		if(!live) return ;
		Color c = g.getColor();
		g.setColor(Color.MAGENTA);
		g.fillRect(x, y, WIDTH, HEIGHT);
		move();
	}
	private void move() {
		step++;
		if(step == pos.length){
			step = 0;
		}
		x = pos[step][0];
		y = pos[step][1];
	}
	public Rectangle getRec(){
		return new Rectangle(x, y, WIDTH, HEIGHT);
	}
}
