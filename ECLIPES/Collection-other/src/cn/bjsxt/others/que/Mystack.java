package cn.bjsxt.others.que;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 使用队列实现自定义堆栈
 * 1、弹
 * 2、压
 * 3、获取头
 * @author llf
 *
 * @param <E>
 */
public class Mystack<E> {
 //容器
	private Deque<E> container = new ArrayDeque<E>();
	private int cap;
	public Mystack(int cap) {
		super();
		this.cap = cap;
	}
	
	//压栈
	public boolean push(E e){
		if(container.size()+1>cap){
			return false;
		}
		return container.offerLast(e);
	}
	
	//弹栈
	public E pop(){
		return container.pollLast();
	}
	
	//获取
	public E peek(){
		return container.peekLast();
	}
	
	public int size(){
		return this.container.size();
	}
}
