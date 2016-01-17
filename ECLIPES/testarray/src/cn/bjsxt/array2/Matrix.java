package cn.bjsxt.array2;



public class Matrix {
	public static void main(String[] args){
		int a[][] = {
				{1,3,6},
				{2,4,9},
				{1,3,5}
		};
		int b[][] = {
				{5,6,6},
				{7,8,8},
				{2,3,6}
		};
		//int[][] c = add(a,b);
		//print(c);
		int[] d = {1,2,335,45,65,98};
		//Matrix m = new Matrix();
		for(int i:d){//数组的遍历 
			System.out.println(i);
		}
		//sort(d);
	}
	
	public static int[][] add(int[][] a,int[][] b){
		int[][] c = new int[a.length][b.length];
		for(int i = 0;i<c.length;i++){
			for(int j = 0;j<c.length;j++){
				c[i][j] = a[i][j] + b[i][j];
			}
		}
		return c;
	}
	
	
	public static void print(int[][] c){
		for(int i = 0;i<c.length;i++){
			for(int j = 0;j<c.length;j++){
				System.out.print(c[i][j]+"\t");
			}
			System.out.println();
		}
	}

	public static void sort(int[] a){
		int n = a.length;
		for(int i = n-1;i >= 0;i--){
			int t;
			for(int j = 0;j < i;j++){
				if(a[j]>a[i]){
					t = a[j];
					a[j] = a[i];
					a[i] = t;
				}
				
			}
			
			
		}
		for(int i = 0; i<1000;i++){
			System.out.print(a[i]);
			
		}
	}
}
	
	

