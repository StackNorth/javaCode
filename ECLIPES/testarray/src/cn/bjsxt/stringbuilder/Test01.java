package cn.bjsxt.stringbuilder;
/**
 * ���Կɱ��ַ����У�StringBuilder���̲߳���ȫ��Ч�ʸߣ���StringBurrer���̰߳�ȫ��Ч�ʵͣ�
 * @author llf
 *
 */
public class Test01 {
	public static void main(String[] args){
		StringBuilder sb = new StringBuilder();//��ʼ����Ϊ
		StringBuilder sb1 = new StringBuilder(32);//��ʼ����Ϊ
		StringBuilder sb2 = new StringBuilder("abcd");//��ʼ����Ϊ
		sb2.append("efg").append(321).append("kjg");//������	
		System.out.println(sb2);
		System.out.println("########################");
		StringBuilder gh = new StringBuilder("a");
		for(int i = 0; i <1000;i++)
		{
			gh.append(i);
		}
		System.out.println(gh);
	}
}
