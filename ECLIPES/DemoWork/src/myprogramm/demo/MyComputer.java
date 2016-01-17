package myprogramm.demo;


import java.util.Scanner;
/*
import myapp.circle.Circle;
import myapp.squre.Squre;
*/



public class MyComputer {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Squre s = new Squre();
		Circle c = new Circle();
		s.setBc(sc.nextDouble());
		c.setR(sc.nextDouble());
		if(s.getBc()>c.getR()){
			System.out.println("≤Ó÷µ:"+Math.abs(s.area()-c.grith()));
		}else{
			System.out.println("≤Ó÷µ:"+Math.abs(s.grith()-c.area()));	
		}

	}
}
 class Squre {
	private double bc = 0;

	public double getBc() {
		return bc;
	}
	public void setBc(double bc) {
		this.bc = bc;
	}
	public double grith(){
		return 4*bc;
	}
	public double area(){
		return bc*bc;
	}
	
}
 class Circle {
	private double r = 0;
	public static final double PI =3.14;
	public double getR() {
		return r;
	}

	public void setR(double r) {
		this.r = r;
	}
	public double grith(){
		return PI*2*r;
	}
	public double area(){
		return PI*r*r;
	}
	
}