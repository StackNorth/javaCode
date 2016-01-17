package cn.bjsxt.sort.rafeType;

public class Goods {
	private int fav;
	//收藏量
	private double price;
	//价格
	private String name;
	//商品名
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
		return "点击量" + this.fav + "价格" + this.price + "商品名" + name + "\n";
	}
	
	
}
