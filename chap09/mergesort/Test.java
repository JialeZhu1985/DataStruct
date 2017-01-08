package mergesort;

import java.util.Arrays;
import java.util.Random;

import com.sun.scenario.effect.Merge;

public class Test {
	
	public static void main(String[] args) {
		int[] nums = new int[]{8,17,12,5,31,19,28,1,20,0,2,7,2,19,13,27,14,19,6,3};
		int[] nums2 = nums.clone();
		int[] nums3 = Arrays.copyOf(nums, nums.length);
		
//		MergeSort.printNums(nums);
////		MergeSort.mergeSort(nums);
//		MergeSort.mergeSort(nums);
//		MergeSort.printNums(nums);
		MergeSort.printNums(nums3);
		MergeSort2.mergeSort2(nums3);
		MergeSort.printNums(nums3);
	}
}
