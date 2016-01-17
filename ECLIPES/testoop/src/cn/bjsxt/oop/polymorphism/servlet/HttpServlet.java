package cn.bjsxt.oop.polymorphism.servlet;

public class HttpServlet {
	public void service(){
		System.out.println("HttpService¡£service()");
		doGet();
	}
	
	public void doGet(){
		System.out.println("HttpService.doGet()");
	}
	
}
