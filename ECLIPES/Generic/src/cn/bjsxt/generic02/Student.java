package cn.bjsxt.generic02;
/**
 * �����ࣺ����ʱʹ�÷���
 * ��ĸ����㶨�壬������ĸ��T K V E ?
 * @author llf
 *ʹ��ʱȷ������
 *ע�⣺
 *1������ֻ��ʹ���������ͣ�����ʹ�û�������
 *2����������ʱ������ʹ�þ�̬�ķ���������
 * @param <T>
 */
public class Student<T1,T2> {
	private T1 javaScore;
	private T2 oracleScore;
	
	
	
	public T1 getJavaScore() {
		return javaScore;
	}



	public void setJavaScore(T1 javaScore) {
		this.javaScore = javaScore;
	}



	public T2 getOracleScore() {
		return oracleScore;
	}



	public void setOracleScore(T2 oracleScore) {
		this.oracleScore = oracleScore;
	}



	public static void main(String[] args) {
		//ʹ��ʱָ������
		Student<String,Integer> s = new Student<String,Integer>();
		//�������ͼ��
		s.setJavaScore("����");
		//����ת��
		int i = s.getOracleScore();//�Զ�����
	}
}
