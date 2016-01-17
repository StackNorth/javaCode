package cn.bjxst.io.Others;

public class Employee implements java.io.Serializable{
	private transient String name;
	private double salary;
	
	public Employee() {
	}
	
	public Employee(String name, double salary) {
		super();
		this.name = name;
		this.salary = salary;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public double getSalary() {
		return salary;
	}
	
	public void setSalary(double salary) {
		this.salary = salary;
	}
	

}
