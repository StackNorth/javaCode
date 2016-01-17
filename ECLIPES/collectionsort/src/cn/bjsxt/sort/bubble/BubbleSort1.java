package cn.bjsxt.sort.bubble;

import java.util.Arrays;

public class BubbleSort1 {
	public static void main(String[] args) {
		int[] arr = {5,4,10,9,8,7,6,5};
		boolean sorted = true;
		for(int i=0;i<arr.length-1;i++){
			 sorted = true;
			for(int j = 0;j<(arr.length-i-1);j++){
				if(arr[j]>arr[j+1]){
					int temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
					sorted = false;
				}
			}
			if(sorted)break;
		}
		System.out.println(Arrays.toString(arr));
	}
}
