package cn.bjsxt.test;

public class TestMultiplicationTable {
	/*
	 * 测试for循环的方法
	 * */
	public void testFor(){
	for(int i=1;i<10;i++){
		for(int j=1;j<=i;j++)
			System.out.print(i+"*"+j+"="+(i*j)+" ");
		System.out.println();
	}  
 }
 /*
  * 测试while循环的方法
  * */
 public void testWhile(){
	 int i=1,j;
	 while(i<10){
		 j=1;
		 while(j<=i){
			 System.out.print(i+"*"+j+"="+(i*j)+" ");
			 j++;
		 }
		 i++;
		 System.out.println();
	 }
		
 } 
 /*
  * 测试dowhile循环的方法
  * */
 public void testDoWhile(){
	 int i=1,j;
	 do{
		 j=1;
		 do{
			 System.out.print(i+"*"+j+"="+(i*j)+" ");
			 j++;	  
		 }while(j<=i);
		 i++;
		 System.out.println();		 
	 }while(i<10);
	 
	 
	 
 }
 public static void main(String[] args) {
	//实例化一个对象，方便对方法的调用
	TestMultiplicationTable t = new TestMultiplicationTable();
	//测试for循环
	t.testFor();
	//测试while循环
	t.testWhile();
	//测试dowhile循环
	t.testDoWhile();
}
}
