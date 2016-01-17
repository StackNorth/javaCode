package facetoproject.mywork;

import java.util.Scanner;

public class Gess {
	static int j;
	public static void main(String[] args){
		A a = new A();
		Scanner input = new Scanner(System.in);
		System.out.println("请输入数字");
		do{
			int i = input.nextInt();
			if(i < a.v){
				System.out.println("输入的数字小了");
			}if(i > a.v){
				System.out.println("输入的数字大了");
			}if(i == a.v){
				System.out.println("恭喜你，猜对了");
				j = i;
			}
		}while(j != a.v);
	}
}

class A{
int v = 100;
}