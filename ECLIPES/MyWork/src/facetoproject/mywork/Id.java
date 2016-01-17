package facetoproject.mywork;

public class Id {
	private int id;
	public void setId(int id){
	this.id = id;
	}
	
	public int getId(){
		return this.id;
	}
	
	public static void main(String[] args) {
		Id i = new Id();
		i.setId(123);
		System.out.println(i.getId());
		
	}
}
