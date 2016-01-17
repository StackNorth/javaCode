import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;


public class TankClient extends Frame{
	public void lunchFrame(){
		this.setTitle("TankWar");
		this.setLocation(400, 300);
		this.setSize(800,600);
		//关闭窗口监听
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		
		});
		this.setResizable(false);//大小改变
		this.setVisible(true);
	}
	public static void main(String[] args) {
		TankClient tc = new TankClient();
		tc.lunchFrame();
	}
}
