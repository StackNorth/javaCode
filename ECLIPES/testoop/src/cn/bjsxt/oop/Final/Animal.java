package cn.bjsxt.oop.Final;

public /*final*/ class Animal {//final��������˵������಻�ܱ��̳�
	public void run(){
		System.out.println("benbao");//final�ӵ�����ǰ�棬��ζ�Ÿ÷������ܱ�������д
	}
	
	
}


class Brid extends Animal {
	public void run(){
		super.run();
		System.out.println("feixiang ");

	}
}
	