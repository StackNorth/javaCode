package facetoproject.mywork;

public class LianXi {
	public LianXi(int a, int b){
		int max;
		if(a > b){
			max = a;
		}else{
			max = b;
		}
		System.out.println("最大值是：" + max);
	}
	
	public LianXi(double x, double y, double z){
		double product;
		product = x*y*z;
		System.out.println("三个数的乘积为：" + product);
	}
	
	public LianXi(String str1, String str2){
		if(str1.equals(str2)){//equals 相当于 ==
			System.out.println("相同");
		}else{
			System.out.println("不相同");
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
