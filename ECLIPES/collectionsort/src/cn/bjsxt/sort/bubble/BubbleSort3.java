package cn.bjsxt.sort.bubble;

import java.util.Arrays;
import java.util.Date;

public class BubbleSort3 {
	public static void main(String[] args) {
		Date[] arr = new Date[3];
		arr[0] = new Date();
		arr[1] = new Date(System.currentTimeMillis()-1000*60*60);
		arr[2] = new Date(System.currentTimeMillis()+1000*60*60);
		sortfinal(arr);
	}
	public static void sortfinal(Date[] arr){
		boolean sorted = true;
		for(int i=0;i<arr.length-1;i++){
			sorted = true;
			for(int j = 0;j<(arr.length-i-1);j++){
				if(((Comparable)arr[j]).compareTo(arr[j+1])>0){
					Date temp = arr[j];
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
