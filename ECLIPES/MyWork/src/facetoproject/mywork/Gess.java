package facetoproject.mywork;

import java.util.Scanner;

public class Gess {
	static int j;
	public static void main(String[] args){
		A a = new A();
		Scanner input = new Scanner(System.in);
		System.out.println("����������");
		do{
			int i = input.nextInt();
			if(i < a.v){
				System.out.println("���������С��");
			}if(i > a.v){
				System.out.println("��������ִ���");
			}if(i == a.v){
				System.out.println("��ϲ�㣬�¶���");
				j = i;
			}
		}while(j != a.v);
	}
}

class A{
int v = 100;
}