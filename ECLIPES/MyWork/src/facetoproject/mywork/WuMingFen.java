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
			System.out.println(theMa + quantity + "带汤的");
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
			System.out.println(theMa + quantity + "带汤的");
		}else{
			System.out.println(theMa + quantity + "不带汤的");
		}
	}
	
	public static void main(String[] args) {
		WuMingFen w = new WuMingFen("酸辣面码",2,true);
		w.check();
	}
}
