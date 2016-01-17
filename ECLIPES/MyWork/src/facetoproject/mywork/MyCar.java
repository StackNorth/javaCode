package facetoproject.mywork;

public class MyCar {
	private int tyre;
	private String color;
	private int weight;
	private int speed;
	public MyCar(int tyre, String color, int weight) {
		super();
		this.tyre = tyre;
		this.color = color;
		this.weight = weight;
	}
	
	public MyCar(int tyre, String color) {
		super();
		this.tyre = tyre;
		this.color = color;
	}

	
	public MyCar(int tyre) {
		super();
		this.tyre = tyre;
	}

	public void upSpeed(int speed){
		this.speed = speed + 20;
		System.out.println("my car is speed:" + this.speed);
	}
	
	public void downSpeed(int speed){
		this.speed = speed - 10;
		System.out.println("my car is speed:" + this.speed);
	}
	
	public void stop(){
		System.out.println("stop driving");
	}
	
	public void start(){
		System.out.println("strat driving");
	}
	
	public static void main(String[] args) {
		MyCar c = new MyCar(4,"yellow",5);
		c.start();
		c.speed = 30;
		c.upSpeed(c.speed);
		c.downSpeed(c.speed);
		c.stop();
	}
}
