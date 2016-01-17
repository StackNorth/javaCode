package cn.bjsxt.test;

public class TestException {
	public static void main(String[] args){
	//	int i = 1/0;
	//	Computer c = null;
	//	if(c != null){
		//	c.start();//对象为null，调用了对象方法或属性,会出现异常
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
			System.out.println("计算机启动");
		}
		
	}
}
