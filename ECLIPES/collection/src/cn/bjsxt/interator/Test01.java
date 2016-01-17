package cn.bjsxt.interator;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class Test01 {
	public static void main(String[] args) {
		List list = new ArrayList();
		list.add("aaa");
		list.add("bbb");
		list.add("ccc");
		//通过索引遍历list
		 for(int i = 0;i<list.size();i++){
			 System.out.println(list.get(i));
		 }
		 //通过迭代器遍历list
		 for(Iterator iter2 = list.iterator();iter2.hasNext();){
			 	String str = (String)iter2.next();
				 System.out.println(str);
			 }
		 
		 Set set = new HashSet();
		 set.add("高琪");
		 set.add("高琪2");
		 set.add("高琪3");
		 //Iterator iter = set.iterator();//迭代用来遍历
		// while(iter.hasNext()){
		 //通过迭代器遍历set
			for(Iterator iter = set.iterator();iter.hasNext();){
		 	String str = (String)iter.next();
			 System.out.println(str);
		 }
		 
		 
	}
}
