package com.bjsxt.thread.create;
/**
 * ��̬����  ���ģʽ
 * 1����ʵ��ɫ
 * 2�������ɫ��������ʵ��ɫ������   �� Thread��
 * 3������ʵ����ͬ�Ľӿ�
 * @author llf
 *
 */
public class StaticProxy {
	public static void main(String[] args) {
		//�������ǽ�ɫ
		You you =new You();
		//���������ɫ*��ʵ��ɫ������
		WeddingCompany company=new WeddingCompany(you);
		//ִ������ 
		company.Mary();
	}
}
//�ӿ�
interface  Marry{
	void Mary();
}
//��ʵ��ɫ
class You implements Marry{

	@Override
	public void Mary() {
			System.out.println("you and i Marry");
	}
}
//�����ɫ
class WeddingCompany implements Marry{
	private Marry you;
	public WeddingCompany(){
	}
	public WeddingCompany(Marry you){
	this.you=you;
	}
	public void before(){
		System.out.println("�����·�");
		
	}
	public void after(){
			System.out.println("˯��");
		
	}
	
	public void Mary() {		
		before();
		you.Mary();
		after();
	}
	
	
}