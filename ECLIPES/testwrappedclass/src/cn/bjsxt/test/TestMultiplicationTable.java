package cn.bjsxt.test;

public class TestMultiplicationTable {
	/*
	 * ����forѭ���ķ���
	 * */
	public void testFor(){
	for(int i=1;i<10;i++){
		for(int j=1;j<=i;j++)
			System.out.print(i+"*"+j+"="+(i*j)+" ");
		System.out.println();
	}  
 }
 /*
  * ����whileѭ���ķ���
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
  * ����dowhileѭ���ķ���
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
	//ʵ����һ�����󣬷���Է����ĵ���
	TestMultiplicationTable t = new TestMultiplicationTable();
	//����forѭ��
	t.testFor();
	//����whileѭ��
	t.testWhile();
	//����dowhileѭ��
	t.testDoWhile();
}
}
