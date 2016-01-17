package cn.bjsxt.test;
/**
 * 测试字符串时间和对象的转化
 */
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TestDateFormat {
	public static void main(String[] args){
		DateFormat df = new  SimpleDateFormat("yyy年mm月dd日 hh:mm:ss");
		Date d = new Date(165135L);
		String str = df.format(d);//将时间对象按照格式化字符串，转化成字符串
		System.out.println(str);
		System.out.println("#################################");
		String str2 = "1977-7-7 10:23:15";
		DateFormat df2 = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		try {
			Date d2 = df2.parse(str2);
			System.out.println(d2);
		} catch (ParseException e) {
		    e.printStackTrace();
		}
	}
}
