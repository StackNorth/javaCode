package facetoproject.mywork;

public class Web {
	private int ID;
	private int mima;
	private String e;
	
	public Web(int ID,int mima,String e){
		this.ID = ID;
		this.mima = mima;
		this.e = e;
		System.out.println(ID +"\t"+ mima + "\t" + e);
	}
	
	public Web(int ID,int mima){
		this.ID = ID;
		this.mima = mima;
		this.e = ID + "@gameschool.com";
		System.out.println(ID +"\t"+ mima + "\t" + e);
	}
	public static void main(String[] args) {
		Web w = new Web(123,12);
		
	}
}
