package cn.bjsxt.others.que;
/**
 * ≤‚ ‘∂”¡–//
 * @author llf
 *
 */
public class Demo02 {
	public static void main(String[] args) {
		Mystack<String> backHistory = new Mystack<String>(3);
		backHistory.push("www.baidu.com");
		backHistory.push("www.google.com");
		backHistory.push("www.sina.com");
		backHistory.push("www.bjsxt.cn");
		String item = null;
		while(null != (item = backHistory.pop())){
			System.out.println(item);
		}
	}
	
}
