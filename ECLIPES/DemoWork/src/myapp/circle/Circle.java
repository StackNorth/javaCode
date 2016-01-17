package myapp.circle;

public class Circle {
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