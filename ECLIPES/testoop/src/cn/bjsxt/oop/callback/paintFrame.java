package cn.bjsxt.oop.callback;

public class paintFrame {
	public static void drawFrame(MyFrame f){
		System.out.println("启动线程");
		System.out.println("增加循环");
		System.out.println("查看消息线");
		f.paint();
		System.out.println("启动缓存，增加效率");
	}
	public static void main(String[] args){
		drawFrame(new GameFrame01());
	}
}

class GameFrame01 extends MyFrame{
	public void paint(){
		System.out.println("GameFrame01.paint()");
		System.out.println("huachuangk");
	}
	
}
