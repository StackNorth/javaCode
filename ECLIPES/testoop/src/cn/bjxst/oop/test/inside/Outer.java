package cn.bjxst.oop.test.inside;

public class Outer {
	public static void main(String[] args){
		face f= new face();
		face.Nose  n =f.new Nose();
		n.breath();
		face.Ear e = new face.Ear();
		e.listen();
	}
}


class face {
	int type = 2;
	static String color = "songse";
	class Nose{
		String  type;
		
		void breath(){
			System.out.println("HUXI");
			
		}

	
}

	static class Ear{
		void listen(){

			System.out.println(color);
			System.out.println("wozaiting ");
			
		}
	
	}
}