package facetoproject.mywork;

public class LianXi {
	public LianXi(int a, int b){
		int max;
		if(a > b){
			max = a;
		}else{
			max = b;
		}
		System.out.println("���ֵ�ǣ�" + max);
	}
	
	public LianXi(double x, double y, double z){
		double product;
		product = x*y*z;
		System.out.println("�������ĳ˻�Ϊ��" + product);
	}
	
	public LianXi(String str1, String str2){
		if(str1.equals(str2)){//equals �൱�� ==
			System.out.println("��ͬ");
		}else{
			System.out.println("����ͬ");
		}
	}
	
	public LianXi(){	
	}
	
	public static void main(String[] args) {
		LianXi l = new LianXi(1,2);
		LianXi l2 = new LianXi(1,2,4);
		LianXi l3 = new LianXi("abc","adc");
	}
}
