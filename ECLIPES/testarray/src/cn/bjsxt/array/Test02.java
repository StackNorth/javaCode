package cn.bjsxt.array;

public class Test02 {
	public static void main(String[] args){
		//����
		int[] a;
		int b[];
		//��������
		a = new int[4];
		b = new int[5];		
		
		//��ʼ��(������Ԫ�صĳ�ʼ����
		//����Ԭ���൱�ڶ���ĳ�Ա������ϵͳĬ�ϳ�ʼ����
		//��̬��ʼ��
		a[0] = 23;
		
		for(int i = 0;i < a.length;i++)
			a[i] = i*12;
		//��̬��ʼ��
		int c[] = {1,2,3,4,5,6,7}; 
		Car[] cars = {new Car("benchi"),new Car("baoma")};
		Car c2 = new Car("benchi");
		System.out.println(c2 == cars[0]);
		 
	}

	
}
