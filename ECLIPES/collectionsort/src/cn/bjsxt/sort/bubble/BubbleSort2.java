package cn.bjsxt.sort.bubble;
/**
 * ¿¼ÂÇ´æÔÚË³Ðò
 */
import java.util.Arrays;

public class BubbleSort2 {
	public static void main(String[] args) {
	//	int[] arr = {3,4,5,10,9,8,7,6};
//		sort(arr);
		String[] arr = {"a","bc","abc"};
		sortfinal(arr);
	}
	
	public static void sortfinal(String[] arr){
		boolean sorted = true;
		for(int i=0;i<arr.length-1;i++){
			sorted = true;
			for(int j = 0;j<(arr.length-i-1);j++){
				if(((Comparable)arr[j]).compareTo(arr[j+1])>0){
					String temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
					sorted = false;
				}
			}
			if(sorted)break;
		}
		System.out.println(Arrays.toString(arr));
		
	}
	
	
	public static void sort(int[] arr){
		for(int i=0;i<arr.length-1;i++){
			for(int j = 0;j<(arr.length-i-1);j++){
				if(arr[j]>arr[j+1]){
					int temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
				}
			}
		}
		System.out.println(Arrays.toString(arr));
	}
}
