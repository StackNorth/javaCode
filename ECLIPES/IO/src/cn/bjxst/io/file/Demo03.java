package cn.bjxst.io.file;

import java.io.File;
import java.io.IOException;
/**
 * ���÷���
 * 1���ļ���
 * getName()�ļ�����·����
 * getPath()·����
 * getAbsoluteFile()����·������Ӧ��File����
 * getAbsolutePath()����·����
 * getParent������Ŀ¼�����·���ĸ�Ŀ¼������Ϊnull	
 * 2���ж���Ϣ��
 * exists()
 * canWrite()
 * canRead()
 * isFile()
 * isDirectory()
 * isAbsolute()����ƽ̨���죬ie���̷���ͷ��������/��ͷ
 * @author llf
 *3������length�����ֽ�����ֻ�ܶ�ȡ�ļ��ĳ���
 *4��������ɾ��
 *creatNewFile()�����ڴ������ļ������ڷ���false
 *delete����ɾ���ļ�
 *static creatTempFile����ǰ׺3���ֽڳ�����׺Ĭ��.temp��Ĭ����ʱ�ռ�
 *staticcreatTempFile��ǰ׺3���ֽڳ�����׺Ĭ��.temp��Ŀ¼��
 *deleteOnExit()�˳������ɾ����������ɾ����ʱ�ļ� 
 */
public class Demo03 {
	
	public static void main(String[] args) {
		try {
			test03();
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("�ļ�����ʧ��");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
	//����ɾ���ļ�
	public static void test03() throws IOException, InterruptedException{
		//creatNewFile()�����ڴ������ļ�
		String path="E:/2.txt";
		//String path="E:/con";//conΪϵͳ�ؼ���
		File src= new File(path);
		if(!src.exists()){
			boolean flag= src.createNewFile();//�����µ��ļ�
			System.out.println(flag?"�ɹ�":"ʧ��");
		}
		
		//ɾ���ļ�
		boolean flag=src.delete();
		System.out.println(flag?"�ɹ�":"ʧ��");
		
		File temp = src.createTempFile("tex", ".temp",new File("E:"));
		Thread.sleep(1000);
		temp.deleteOnExit();//�˳���ɾ��
		
		
	
	}
	//2���ж���Ϣ
	public static void test02(){
		String path="E:/2.txt";
		//String path="E:/game";
		//String path="2.txt";
		File src =new File(path);
		//�Ƿ����
		System.out.println("�ļ��Ƿ����"+src.exists());
		//�Ƿ�ɶ�д��canWrite() canRead();
		System.out.println("�ļ��Ƿ�ɶ�д"+src.canWrite()+src.canRead());
		
		// isFile()
		//isDirectory()
		if(src.isFile()){
			System.out.println("�ļ�");
		}else if(src.isDirectory()){
			System.out.println("�ļ���");
		}else{
			System.out.println("�ļ�������");
			
		}
		//isAbsolute()�ж��Ƿ�Ϊ����·��
		System.out.println("�Ƿ�Ϊ����·��"+src.isAbsolute());
		System.out.println("����Ϊ��"+src.length());
	}
	
	
	//1����
	public static void test01(){
		File src = new File("E:/xp/test/test.txt");
		//������ϵ
		System.out.println(src.getName());//��������
		System.out.println(src.getPath());//����Ǿ���·������������·�����������·��
		System.out.println(src.getAbsolutePath());//���ؾ���·��
		System.out.println(src.getParent());//�����ϼ�Ŀ¼��	���û����һ�������ؿ�
	}
}
