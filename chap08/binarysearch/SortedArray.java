package binarysearch;

import java.util.ArrayList;

/**
 * 二分查找类
 * @author PanShan
 * */
public class SortedArray {
	public static<T extends Comparable<? super T>> int binarySearch(T[] nums, int begin, int end, T key) {
		if (begin < 0 || end > nums.length - 1)
			throw new IllegalArgumentException("begin="+begin+",end="+end);
		
		while (begin <= end) {
			int mid = (begin + end) / 2;
			int comres = key.compareTo(nums[mid]);
			
			if (comres < 0) {
				end = mid - 1;
			} else if (comres > 0){
				begin = mid + 1;
			} else {
				return mid;				
			}
		}
		
		return -1;
	}
	
	public static<T extends Comparable<? super T>> int binarySearch2(T[] nums, int begin, int end, T key) {
		if (begin > end) {
			return -1;
		} else {
			int mid = (begin + end) / 2;
			int comres = key.compareTo(nums[mid]);
			
			if (comres < 0)
				return binarySearch2(nums, begin, mid - 1, key);
			else if (comres > 0)
				return binarySearch2(nums, mid + 1, end, key);
			else
				return mid;
		}
	}
	
	public static void main(String[] args) {
		Integer[] nums = new Integer[]{1,3,5,7,9,11,13,15,17,19};
		System.out.println(binarySearch(nums, 0, nums.length - 1, 5));
		System.out.println(binarySearch(nums, 0, nums.length - 1, 4));
		System.out.println(binarySearch2(nums, 0, nums.length - 1, 5));
		System.out.println(binarySearch2(nums, 0, nums.length - 1, 4));
	}
}
