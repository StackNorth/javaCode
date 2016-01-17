package cn.bjsxt.map;

import java.util.ArrayList;
import java.util.List;

/**
 * 班级
 * @author llf
 *
 */
public class classRoom {
	private String no;//班级
	private List<Student> stus;//学生列表
	private double total;//总分
	
	public classRoom() {
		stus = new ArrayList<Student>();
	}
	
	
	public classRoom(String no) {
		this();
		this.no = no;
	}
	public String getNo() {
		return no;
	}
	public void setNo(String no) {
		this.no = no;
	}
	public List<Student> getStu() {
		return stus;
	}
	public void setStu(List<Student> stu) {
		this.stus = stu;
	}
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
	
	
}
