package cn.bjsxt.sort.rafeType;

public class Goods {
	private int fav;
	//�ղ���
	private double price;
	//�۸�
	private String name;
	//��Ʒ��
	public Goods() {
		
	}
	
	
	
	
	public Goods(int fav, double price, String name) {
		super();
		this.fav = fav;
		this.price = price;
		this.name = name;
	}




	public int getFav() {
		return fav;
	}
	public void setFav(int fav) {
		this.fav = fav;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "�����" + this.fav + "�۸�" + this.price + "��Ʒ��" + name + "\n";
	}
	
	
}
