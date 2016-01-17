package cn.bjsxt.sort.bubble;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * 排序 
 * @author llf
 *
 */
public class Utils {
	/**
	 * 对容器排序
	 */
	public static<T extends Comparable<T>> void sort(List<T> list){
		Object[] arr = list.toArray();
		sort(arr);
		for(int i = 0;i<arr.length;i++){
			list.set(i, (T)(arr[i]));
		} 
	}
	
	/**
	 * 使用泛型方法
	 * @param arr
	 */
	
	public static<T extends Comparable<T>> void sort(T[] arr){
		boolean sorted = true;
		for(int i=0;i<arr.length-1;i++){
			sorted = true;
			for(int j = 0;j<(arr.length-i-1);j++){
				if(((Comparable)arr[j]).compareTo(arr[j+1])>0){
					T temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
					sorted = false;
				}
			}
			if(sorted)break;
		}
		
		
	}
	
	
	public static void sort(Object[] arr){
		boolean sorted = true;
		for(int i=0;i<arr.length-1;i++){
			sorted = true;
			for(int j = 0;j<(arr.length-i-1);j++){
				if(((Comparable)arr[j]).compareTo(arr[j+1])>0){
					Object temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
					sorted = false;
				}
			}
			if(sorted)break;
		}
		
		
	}
	
}
