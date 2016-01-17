package cn.bjsxt.array2;

public class Test01 {
	public static void main(String[] args){
	//	int a[][] = {
		//				{1,2},
			//			{2,3,4,5,6},
				//		{5,6,7}
		//};
		int [][] a = new int [3][];
		a[0] = new int[2];
		a[1] = new int[3];
		a[2] = new int[4];
		a[0][0] = 1;
		a[0][1] = 2;
		a[1][0] = 3;
		a[1][1] = 4;
		a[1][2] = 5;
		a[2][0] = 6;
		a[2][1] = 7;
		a[2][2] = 8;
		a[2][3] = 9;
	}
}
