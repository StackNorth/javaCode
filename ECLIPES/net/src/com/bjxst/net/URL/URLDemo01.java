package com.bjxst.net.URL;

import java.net.MalformedURLException;
import java.net.URL;
/**
 * MalformedURLException���ε��쳣
 * @author llf
 *
 */
public class URLDemo01 {
	public static void main(String[] args) throws MalformedURLException {
		//����·������
		URL url= new URL("http://www.baidu.com:80/index.html#aa?");
		//�鿴Э��
		System.out.println("Э��"+url.getProtocol());
		//������
		System.out.println("������"+url.getHost());
		//�˿�
		System.out.println("�˿�"+url.getPort());
		//��Դ
		System.out.println("��Դ"+url.getFile());
		//���·������Դ
		System.out.println("���·������Դ"+url.getPath());
		//ê��
		System.out.println("ê��"+url.getRef());
		System.out.println("����"+url.getQuery());//�����������ź���Ϊ�����������ê�㷵��null�������ڷ�����ȷ
		url = new URL("http://www.baidu.com:80/a/");
		url = new URL(url,"b.txt");//���·��
		System.out.println(url.toString());
	}
}
