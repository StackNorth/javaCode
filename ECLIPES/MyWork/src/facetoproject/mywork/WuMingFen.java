package facetoproject.mywork;

public class WuMingFen {
	String theMa;
	int quantity;
	boolean likeSoup;
	
	public WuMingFen(String theMa,int quantity,boolean likeSoup){
		
		this.theMa = theMa;
		this.quantity = quantity;
		this.likeSoup = likeSoup;
		if(likeSoup == true){
			System.out.println(theMa + quantity + "������");
		}
	}
	
	public WuMingFen(String theMa,int quantity){
		this.theMa = theMa;
		this.quantity = quantity;
	}
	
	public WuMingFen(){
	}
	
	public void check(){
		if(likeSoup == true){
			System.out.println(theMa + quantity + "������");
		}else{
			System.out.println(theMa + quantity + "��������");
		}
	}
	
	public static void main(String[] args) {
		WuMingFen w = new WuMingFen("��������",2,true);
		w.check();
	}
}
