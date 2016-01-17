package cn.bjsxt.sort.rafeType;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

public class NewsItemApp {
	public static void main(String[] args) {
		List<NewsItem> news = new ArrayList<NewsItem>();
		news.add(new NewsItem("��ʧ��",50,new Date()));
		news.add(new NewsItem("�ձ�����",70,new Date(System.currentTimeMillis()-60*60*1000)));
		news.add(new NewsItem("�����籩",40,new Date(System.currentTimeMillis()+60*60*1000)));
		 
		System.out.println("����ǰ��" + news);
		Collections.sort(news);
		System.out.println("�����" + news);
		
	}
}
