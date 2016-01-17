package cn.bjsxt.others.que;

import java.util.ArrayDeque;
import java.util.Queue;

public class Demo01 {
	public static void main(String[] args) {
		Queue<Request> q = new ArrayDeque<Request>();
	//模拟排队情况
		for(int i = 0;i<10;i++){
			final int sum = i;//queue只能调用final修饰的变量
			q.offer(new Request(){
				
				public void deposit() {
					System.out.println("第"+sum+"人办理"+Math.random()*10000);
				}
			});
		}
		dealWith(q);
	}
	//处理业务
	public static void dealWith(Queue<Request> que){
		Request req = null;
		while(null!=(req = que.poll())){//poll获取并移除队列的头，如果此队列为空，则返回null
			req.deposit();
		}
	}
}

interface Request{
	void deposit();
}