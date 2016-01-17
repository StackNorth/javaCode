package cn.bjsxt.interator;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.Iterator;

public class Test02 {
	public static void main(String[] args) {
		Map map = new HashMap();
		Set keys = map.keySet();
		for(Iterator iter = keys.iterator();iter.hasNext();){
			String str = (String)iter.next();
			System.out.println(str + "----"  );
		}
	}
}
