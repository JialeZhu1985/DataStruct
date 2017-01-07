package changeSort;

public class ChangeSort {
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
	 * 冒泡排序(升序)，外层循环控制排序趟数，内层循环控制当前待比较元素*/
	public static void bubbleSort(int[] nums) {
		int len = nums.length;
		
		for (int i = 1; i < len; i++) {
			for (int j = 0; j < len - i; j++) {
				if (nums[j] > nums[j+1]) {
					int tmp = nums[j];
					nums[j] = nums[j+1];
					nums[j+1] = tmp;
				} else
					continue;
			}
		}
	}
	
	public static void bubbleSort2(int[] nums) {
		int len = nums.length;
		
		for (int i = 1; i < len; i++) {
			for (int j = len - 1; j >= i; j--) {
				if (nums[j] < nums[j-1]) {
					int tmp = nums[j];
					nums[j] = nums[j-1];
					nums[j-1] = tmp;
				} else
					continue;
			}
		}
	}
	
	/**
	 * 快速排序算法*/
	public static void quickSort(int[] nums) {
		quickSort(nums, 0, nums.length - 1);
	}
	private static void quickSort(int[] nums, int start, int end) {
		if (0 <= start && start < end && end < nums.length) {
			int front = start;	// 初始头索引
			int tail = end;		// 初始尾索引
			int key = nums[front];	// 选择当前序列的第一个元素为参考元素
			
			while (front < tail) {

				//从后向前，找到第一个小于参考元素的索引
				while (nums[tail] >= key && front < tail) {
					tail--;
				}
				
				//从后面找到了满足条件的元素
				if (front < tail) {
					nums[front++] = nums[tail];	// 移动后面的元素到前面，并更新头指针
				}
				
				//从前向后，找到第一个大于参考元素的索引
				while (nums[front] <= key && front < tail) {
					front++;
				}
				
				//找到了满足条件的元素
				if (front < tail) {
					nums[tail--] = nums[front];	// 移动前面的元素到后面，并更新尾指针
				}
				
			}
			
			nums[front] = key;
			
			quickSort(nums, start, front - 1);
			quickSort(nums, tail + 1, end);
		} else
			return;
	}
	
}
