package selectSort;

/**
 * 选择排序*/
public class SelectSort {
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
	 * 直接选择排序*/
	public static void straightSelect(int[] nums) {
		int len = nums.length;
		
		//外层循环趟数，每一趟确定一个最小值；内层循环代表待比较元素
		for (int i = 0; i < len - 1; i++) {
			int min = i;	// 存放最小值索引
			
			for (int j = i + 1; j < len; j++) {
				if (nums[j] < nums[min])
					min = j;
			}
			
			//交换
			int tmp = nums[i];
			nums[i] = nums[min];
			nums[min] = tmp;
		}
	}
	
	/**
	 * 堆排序*/
	public static void heapSort(int[] nums) {
		int len = nums.length;
		
		//创建最小堆
		for (int parent = len / 2; parent >= 0; parent--) {
			sift(nums, parent, len - 1);
		}
		
		//将根节点和最后一个节点交换位置，nums长度-1，然后再次调整堆
		for (int i = len - 1; i > 0; i--) {
			//将根节点与最后一个子节点交换
			{
				int tmp = nums[0];
				nums[0] = nums[i];
				nums[i] = tmp;
			}
			
			//重新调整堆
			sift(nums, 0, i - 1);
		}
	}

	private static void sift(int[] nums, int parent, int end) {
		int child = parent * 2 + 1;	//左孩子
		int key = nums[parent];		//当前父节点元素
		
		while (child <= end) {	//当前节点存在子节点
			//判断右孩子是否存在，若存在，child指向较小的孩子
			if (child + 1 < end && nums[child + 1] < nums[child]) {
				child++;
			}
			
			//判断父节点和当前孩子节点的大小关系
			if (key > nums[child]) {
				//孩子节点上移
				nums[parent] = nums[child];
				//父节点指针下移
				parent = child;
				//更新子节点
				child = parent * 2 + 1;
			} else {
				break;
			}
		}

		nums[parent] = key;
	}
}
