package changeSort;

public class Test {
	
	public static void main(String[] args) {
		int[] nums = new int[]{8,17,12,5,31,19,28,1,20,0,2,7,2,19,13,27,14,19,6,3};
		int[] nums2 = nums.clone();
		int[] nums3 = nums.clone();
		
		ChangeSort.printNums(nums);
		ChangeSort.bubbleSort(nums);
		ChangeSort.printNums(nums);
		
		ChangeSort.printNums(nums2);
		ChangeSort.bubbleSort2(nums2);
		ChangeSort.printNums(nums2);
		
		ChangeSort.printNums(nums3);
		ChangeSort.quickSort(nums3);
		ChangeSort.printNums(nums3);
	}
}
