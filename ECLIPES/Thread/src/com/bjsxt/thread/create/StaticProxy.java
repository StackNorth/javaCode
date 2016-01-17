package com.bjsxt.thread.create;
/**
 * 静态代理  设计模式
 * 1、真实角色
 * 2、代理角色，持有真实角色的引用   如 Thread类
 * 3、二者实现相同的接口
 * @author llf
 *
 */
public class StaticProxy {
	public static void main(String[] args) {
		//创建真是角色
		You you =new You();
		//创建代理角色*真实角色的引用
		WeddingCompany company=new WeddingCompany(you);
		//执行任务 
		company.Mary();
	}
}
//接口
interface  Marry{
	void Mary();
}
//真实角色
class You implements Marry{

	@Override
	public void Mary() {
			System.out.println("you and i Marry");
	}
}
//代理角色
class WeddingCompany implements Marry{
	private Marry you;
	public WeddingCompany(){
	}
	public WeddingCompany(Marry you){
	this.you=you;
	}
	public void before(){
		System.out.println("布置新房");
		
	}
	public void after(){
			System.out.println("睡觉");
		
	}
	
	public void Mary() {		
		before();
		you.Mary();
		after();
	}
	
	
}