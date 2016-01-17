package cn.bjsxt.sort.col;

public class Person {
	private final String name;
	private final int handsome;//Ë§ÆøÖ¸Êý
	public Person() {
		name = null;
		handsome = 0;
	}
	
	public Person(String name, int handsome) {
		super();
		this.name = name;
		this.handsome = handsome;
	}

	public String getName() {
		return name;
	}


	public int getHandsome() {
		return handsome;
	}

	public String toString() {
		return "Person [name=" + this.name + ", handsome=" + this.handsome + "\n";
	}
	
	
}
