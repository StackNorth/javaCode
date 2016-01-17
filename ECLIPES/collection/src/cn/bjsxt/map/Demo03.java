package cn.bjsxt.map;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 定义一个Student类，属性：name，姓名，classNumber 班号，score成绩
 * 现在将若干对象放入List。统计每个班级的总分和平均分，并打印出来
 * @author llf
 *
 */
public class Demo03 {
	public static void main(String[] args) {
		List<Student> list = new ArrayList<Student>();
		exam(list);
	//统计
		Map<String,classRoom> rooms = new HashMap<String,classRoom>();
		count(rooms,list);
		//打印
		printScore(rooms);
	
	}
	/**
	 * 打印总分和平均分
	 */
	public static void printScore(Map<String,classRoom> rooms){
		Set<Map.Entry<String,classRoom>> entrySet = rooms.entrySet();
		Iterator<Map.Entry<String,classRoom>> it = entrySet.iterator();
		while(it.hasNext()){
			Map.Entry<String,classRoom> entry = it.next();
			classRoom room = entry.getValue();
			double avg = room.getTotal()/room.getStu().size();
			System.out.println("班号为："+room.getNo()+"总分"+room.getTotal()+"平均分"+avg);
		}
	}
	
	
	/**
	 * 统计分数
	 */
	public static void count(Map<String,classRoom> rooms,List<Student> list){
		for(Student stu:list){
			String no = stu.getNo();
			double score = stu.getScore();
			//根据班级编号 查看Map是否存在该班级，分拣
			classRoom room = rooms.get(no);
			if(room == null){//第一次
				room = new classRoom(no);
				rooms.put(no, room);
			}
			//存储总分
			room.setTotal(room.getTotal() + score);
			room.getStu().add(stu);//加入学生
		}
	}
	
	
	
	
	
	/**
	 * 若干个student加入到list里面
	 * @param list
	 */
	public static void exam(List<Student> list){
		list.add(new Student("a","001",80));
		list.add(new Student("b","001",70));
		list.add(new Student("a","002",80));
		list.add(new Student("b","002",80));
		list.add(new Student("a","003",80));
	}
	
	
}
