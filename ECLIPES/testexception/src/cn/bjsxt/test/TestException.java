package cn.bjsxt.test;

public class TestException {
	public static void main(String[] args){
	//	int i = 1/0;
	//	Computer c = null;
	//	if(c != null){
		//	c.start();//����Ϊnull�������˶��󷽷�������,������쳣
		//}	
		//String str = "123456adcs";
		//Integer i = new Integer(str);//" java.lang.NumberFormatException:
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	
	}
	class Computer{
		void start(){
			System.out.println("���������");
		}
		
	}
}
