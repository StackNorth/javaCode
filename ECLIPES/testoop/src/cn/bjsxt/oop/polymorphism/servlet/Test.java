package cn.bjsxt.oop.polymorphism.servlet;

public class Test {
		public static void main(String[] args){
			HttpServlet s = new MyService();
			s.service(); 		
			
		}
}
