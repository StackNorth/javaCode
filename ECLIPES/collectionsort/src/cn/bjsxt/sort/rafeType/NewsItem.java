package cn.bjsxt.sort.rafeType;

import java.text.SimpleDateFormat;
import java.util.Date;

public class NewsItem implements java.lang.Comparable<NewsItem>{
	private String title;
	//标题
	private int hits;
	//点击量
	private Date pubTime;
	//时间
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

	//先按时间降序，点击量升序，标题降序
	public int compareTo(NewsItem o) {
		int result = 0;
		//比较时间
		result = -this.pubTime.compareTo(o.pubTime);//降序
		if(0 == result){
			result = this.hits-o.hits;
			if(0 == result){//点击量相同
				result = -this.title.compareTo(o.title);
			}
		}
		return result;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("标题：").append(this.title);
		sb.append("、时间：").append(new SimpleDateFormat("YYYY-MM-dd mm:ss").format(pubTime));
		sb.append("、点击量：").append(this.hits).append("\n");
		return sb.toString();
	}
	
	
}
