package cn.bjsxt.oop.callback;

public class paintFrame {
	public static void drawFrame(MyFrame f){
		System.out.println("�����߳�");
		System.out.println("����ѭ��");
		System.out.println("�鿴��Ϣ��");
		f.paint();
		System.out.println("�������棬����Ч��");
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
