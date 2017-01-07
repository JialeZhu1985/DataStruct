package insertionSort;

import java.util.Arrays;
import java.util.Random;

public class Test {
	
	public static void main(String[] args) {
		int[] nums = new int[]{8,17,12,5,31,19,28,1,20,0,2,7,2,19,13,27,14,19,6,3};
		int[] nums2 = nums.clone();
		int[] nums3 = Arrays.copyOf(nums, nums.length);
		
		System.out.println(nums == nums2);
		System.out.println(nums == nums3);

		InsertionSort.printNums(nums);
		InsertionSort.straightInsert(nums);
		InsertionSort.printNums(nums);
		
		
		InsertionSort.printNums(nums2);
		InsertionSort.shellSort(nums2);
		InsertionSort.printNums(nums2);
		
		InsertionSort.printNums(nums3);
		InsertionSort.shellSort(nums3);
		InsertionSort.printNums(nums3);
	}
}
