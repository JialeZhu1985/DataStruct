package selectSort;

public class Test {
	
	public static void main(String[] args) {
		int[] nums = new int[]{8,17,12,5,31,19,28,1,20,0,2,7,2,19,13,27,14,19,6,3};
		int[] nums2 = nums.clone();
		int[] nums3 = nums.clone();
		
		SelectSort.printNums(nums);
		SelectSort.straightSelect(nums);
		SelectSort.printNums(nums);
		
		SelectSort.printNums(nums2);
		SelectSort.heapSort(nums2);
		SelectSort.printNums(nums2);
	}
}
