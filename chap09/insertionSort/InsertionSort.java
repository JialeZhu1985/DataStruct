package insertionSort;

public class InsertionSort {
	//遍历当前数组
	public static void printNums(int[] nums) {
		int len = nums.length;
		StringBuffer sb = new StringBuffer("(");
		
		int index = 0;
		for (index = 0; index < len - 1; index++)
			sb.append(nums[index] + ",");
		sb.append(nums[len - 1]);
		sb.append(")\n");
		
		System.out.println(sb.toString());
	}
	
	/**
	 * 直接插入排序，外层循环i代表待插入元素，内层循环j代表待比较元素*/
	public static void straightInsert(int[] nums) {
		int len = nums.length;
		
		for (int i = 1; i < len; i++) {
			int key = nums[i];
			int j = 0;
			
			for (j = i-1; j >= 0; j--) {
				if (key < nums[j])
					nums[j+1] = nums[j];
				else {
					break;
				}
			}
			nums[j+1] = key;
		}
	}
	
	/**
	 * 希尔排序，外层循环delt控制步长，中层循环i代表待插入元素，内层循环j代表待比较元素*/
	public static void shellSort(int[] nums) {
		int len = nums.length;
		
		for (int delt = len / 2; delt > 0; delt /= 2) {
			for (int i = delt; i < len; i++) {
				int key = nums[i];
				int j = 0;
				
				for (j = i - delt; j >= 0; j -= delt) {
					if (key < nums[j])
						nums[j+delt] = nums[j];
					else {
						break;
					}
				}

				nums[j+delt] = key;
			}
		}
	}
}
