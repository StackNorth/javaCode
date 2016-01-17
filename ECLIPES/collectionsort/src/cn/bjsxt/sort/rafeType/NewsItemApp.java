package cn.bjsxt.sort.rafeType;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

public class NewsItemApp {
	public static void main(String[] args) {
		List<NewsItem> news = new ArrayList<NewsItem>();
		news.add(new NewsItem("马航失事",50,new Date()));
		news.add(new NewsItem("日本地震",70,new Date(System.currentTimeMillis()-60*60*1000)));
		news.add(new NewsItem("美国风暴",40,new Date(System.currentTimeMillis()+60*60*1000)));
		 
		System.out.println("排序前：" + news);
		Collections.sort(news);
		System.out.println("排序后：" + news);
		
	}
}
