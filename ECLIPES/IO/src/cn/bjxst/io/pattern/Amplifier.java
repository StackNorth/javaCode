package cn.bjxst.io.pattern;
/**
 * ������֮��Ĺ�ϵ��
 * 1���������β�|�ֲ�����
 * 2������������
 * 			�ۺϣ����������벿��   ��һ�µ��������� ������
 * 			��ϣ����������벿��  һ�µ���������  �������
 * 3���̳У��������ϵ
 * 4��ʵ�֣��ӿ���ʵ�����ϵ
 * @author llf
 *
 */
public class Amplifier {
	private Voice voice;
	public Amplifier() {
	}
	public Amplifier(Voice voice) {
		super();
		this.voice = voice;
	}
	public void say(){
		System.out.println(voice.getVoice()*1000);
		
	}
}
