package cn.bjsxt.generic02;
/**
 * ���ͷ���<>��������
 * ���ͷ���ֻ�ܷ��ʶ������Ϣ�������޸���Ϣ
 * @author llf
 *
 */
public class TestMethod {
	public static void main(String[] args) {
		test("a");
	}
	public static <T> void test(T t){
		System.out.println(t);
	}
}
