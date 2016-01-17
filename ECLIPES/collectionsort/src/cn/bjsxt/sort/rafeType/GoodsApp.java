package cn.bjsxt.sort.rafeType;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GoodsApp {
	public static void main(String[] args) {
		List<Goods> list = new ArrayList<Goods>();
		list.add(new Goods(500,60,"fangbianmian"));
		list.add(new Goods(5000,70,"shuiguo"));
		list.add(new Goods(50000,80,"shui"));
		Collections.sort(list,new GoodsPriceComp());
		System.out.println(list);
		Collections.sort(list,new GoodsFavComp());
		System.out.println(list);
	}
}
