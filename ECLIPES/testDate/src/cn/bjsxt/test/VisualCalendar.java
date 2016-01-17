package cn.bjsxt.test;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;

/**
 * 可视化日历程序
 * @author llf
 *
 */
public class VisualCalendar {
	public static void main(String[] args){
		System.out.println("请输入日期（按照格式：2030-2-3）:");
		Scanner scanner = new Scanner(System.in);
		String temp = scanner.nextLine();
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		try {
			Date date = format.parse(temp);
			Calendar c = new GregorianCalendar();
			c.setTime(date);
			int day = c.get(Calendar.DATE);
			c.set(c.DATE, 1);
			
			int maxDate = c.getActualMaximum(Calendar.DATE);
			System.out.println("日\t一\t二\t三\t四\t五\t六\t	");
			for(int i = 0;i< c.get(Calendar.DAY_OF_WEEK)-1;i++){
				System.out.print('\t');
			}
	
			for(int i = 1;i <= maxDate;i++){
				if(i == day){
					System.out.print("*");	
				}
				System.out.print(i+"\t");
				int maxW = c.get(Calendar.DAY_OF_WEEK);
				if(maxW == Calendar.SATURDAY){
					System.out.print('\n');
				}
				c.add(Calendar.DATE, 1);
			}
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		
		
	}
}
