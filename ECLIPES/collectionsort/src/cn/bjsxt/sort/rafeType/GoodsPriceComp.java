package cn.bjsxt.sort.rafeType;
/**
 * 
 * @author llf
 * 
 */
public class GoodsPriceComp implements java.util.Comparator<Goods>{

	public int compare(Goods o1, Goods o2) {
		return -(o1.getPrice()-o2.getPrice()>0?1:o1.getPrice()==o2.getPrice()?0:-1);
	} 	

}
