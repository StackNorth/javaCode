package cn.bjsxt.map;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * ����һ��Student�࣬���ԣ�name��������classNumber ��ţ�score�ɼ�
 * ���ڽ����ɶ������List��ͳ��ÿ���༶���ֺܷ�ƽ���֣�����ӡ����
 * @author llf
 *
 */
public class Demo03 {
	public static void main(String[] args) {
		List<Student> list = new ArrayList<Student>();
		exam(list);
	//ͳ��
		Map<String,classRoom> rooms = new HashMap<String,classRoom>();
		count(rooms,list);
		//��ӡ
		printScore(rooms);
	
	}
	/**
	 * ��ӡ�ֺܷ�ƽ����
	 */
	public static void printScore(Map<String,classRoom> rooms){
		Set<Map.Entry<String,classRoom>> entrySet = rooms.entrySet();
		Iterator<Map.Entry<String,classRoom>> it = entrySet.iterator();
		while(it.hasNext()){
			Map.Entry<String,classRoom> entry = it.next();
			classRoom room = entry.getValue();
			double avg = room.getTotal()/room.getStu().size();
			System.out.println("���Ϊ��"+room.getNo()+"�ܷ�"+room.getTotal()+"ƽ����"+avg);
		}
	}
	
	
	/**
	 * ͳ�Ʒ���
	 */
	public static void count(Map<String,classRoom> rooms,List<Student> list){
		for(Student stu:list){
			String no = stu.getNo();
			double score = stu.getScore();
			//���ݰ༶��� �鿴Map�Ƿ���ڸð༶���ּ�
			classRoom room = rooms.get(no);
			if(room == null){//��һ��
				room = new classRoom(no);
				rooms.put(no, room);
			}
			//�洢�ܷ�
			room.setTotal(room.getTotal() + score);
			room.getStu().add(stu);//����ѧ��
		}
	}
	
	
	
	
	
	/**
	 * ���ɸ�student���뵽list����
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
