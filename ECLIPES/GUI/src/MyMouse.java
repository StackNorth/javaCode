

import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Iterator;

public class MyMouse {
	public static void main(String[] args) {
		new MyFrame("drawing");
	}
}
class MyFrame extends Frame{
	ArrayList<Point> points=null;
	public MyFrame(String s) {
		super(s);
		points = new ArrayList<Point>();
		setLayout(null);
		setVisible(true);
		setBounds(300, 300, 200, 200);
		setBackground(Color.pink);
		addMouseListener(new Monitor());
	}
	public void paint(Graphics g){
		Iterator<Point> i =points.iterator();
		while(i.hasNext()){
			Point p =i.next();
			g.setColor(Color.black);
			g.fillOval(p.x,p.y,10,10);
			
		}
	}
	public  void addPaint(Point point) {
		points.add(point);
	}	

}
class Monitor extends MouseAdapter{
	public void mousePressed(MouseEvent e){
		MyFrame f= (MyFrame)e.getSource();
		f.addPaint(new Point(e.getX(),e.getY()));
		f.repaint();
		
	}
	
}