package cn.bjsxt.sort.rafeType;

import java.text.SimpleDateFormat;
import java.util.Date;

public class NewsItem implements java.lang.Comparable<NewsItem>{
	private String title;
	//����
	private int hits;
	//�����
	private Date pubTime;
	//ʱ��
	public NewsItem(String title, int hits, Date pubTime) {
		super();
		this.title = title;
		this.hits = hits;
		this.pubTime = pubTime;
	}
		
	public NewsItem() {
	}

	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getHits() {
		return hits;
	}
	public void setHits(int hits) {
		this.hits = hits;
	}
	public Date getPubTime() {
		return pubTime;
	}
	public void setPubTime(Date pubTime) {
		this.pubTime = pubTime;
	}

	//�Ȱ�ʱ�併�򣬵�������򣬱��⽵��
	public int compareTo(NewsItem o) {
		int result = 0;
		//�Ƚ�ʱ��
		result = -this.pubTime.compareTo(o.pubTime);//����
		if(0 == result){
			result = this.hits-o.hits;
			if(0 == result){//�������ͬ
				result = -this.title.compareTo(o.title);
			}
		}
		return result;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("���⣺").append(this.title);
		sb.append("��ʱ�䣺").append(new SimpleDateFormat("YYYY-MM-dd mm:ss").format(pubTime));
		sb.append("���������").append(this.hits).append("\n");
		return sb.toString();
	}
	
	
}
