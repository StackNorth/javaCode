package cn.bjsxt.test;
/**
 * �Զ����쳣
 * @author llf
 *
 */
public class TestMyException extends Exception{
	
	public TestMyException(){
		
	}
	
public TestMyException(String message){
		super(message);
	}
}

class MyException{
	void test() throws Exception{}
	public static void main(String[] args){
//		new TestMyException().test();
	}
	
}