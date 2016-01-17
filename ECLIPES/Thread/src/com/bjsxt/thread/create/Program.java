package com.bjsxt.thread.create;
/**1推荐使用Runnable创建线程
 *  1）避免单继承的局限性
 *  2）便于共享资源
 * 使用Runnable创建线程 
 * 1）类实现Runnable接口+重写run()-->真实角色类
 * 2）启动多线程 使用静态代理
 * //创建真实角色
 * //创建代理角色+真实角色的引用
 * //调用方法，启动线程
 * @author llf
 *
 */
public class Program implements Runnable {

	@Override
	public void run() {
		for(int i=0;i<100;i++){
			System.out.println("一边敲代码"+i);
			
		}
	}
	
}
