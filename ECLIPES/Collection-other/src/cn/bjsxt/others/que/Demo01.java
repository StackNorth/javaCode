package cn.bjsxt.others.que;

import java.util.ArrayDeque;
import java.util.Queue;

public class Demo01 {
	public static void main(String[] args) {
		Queue<Request> q = new ArrayDeque<Request>();
	//ģ���Ŷ����
		for(int i = 0;i<10;i++){
			final int sum = i;//queueֻ�ܵ���final���εı���
			q.offer(new Request(){
				
				public void deposit() {
					System.out.println("��"+sum+"�˰���"+Math.random()*10000);
				}
			});
		}
		dealWith(q);
	}
	//����ҵ��
	public static void dealWith(Queue<Request> que){
		Request req = null;
		while(null!=(req = que.poll())){//poll��ȡ���Ƴ����е�ͷ������˶���Ϊ�գ��򷵻�null
			req.deposit();
		}
	}
}

interface Request{
	void deposit();
}