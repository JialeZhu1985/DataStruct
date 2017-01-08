package mergesort;

/**
 * 归并排序算法:自底向上归并*/
public class MergeSort {
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
	
	//一次归并，合并相邻的子序列
	public static void merge(int[] x, int[] tmp, int begin1, int begin2, int n) {
		int len = x.length;
		
		int index1 = begin1, index2 = begin2, index = index1;	//索引
		
		while (index1 < begin1 + n && index2 < begin2 + n && index2 < len) {
			if (x[index1] < x[index2])
				tmp[index++] = x[index1++];
			else
				tmp[index++] = x[index2++];
		}
		
		while (index1 < begin1 + n && index1 < len)
			tmp[index++] = x[index1++];
		while (index2 < begin2 + n && index2 < len)
			tmp[index++] = x[index2++];
	}

	//一趟归并，合并两两相邻的子序列
	public static void mergePass(int[] x, int n) {
		int len = x.length;
		int[] tmp = new int[len];		//辅助数组
		
		for (int begin = 0; begin < len; begin += 2*n) {
			merge(x, tmp, begin, begin + n, n);
		}
		
		//移动数组元素
		for (int index = 0; index < len; index++)
			x[index] = tmp[index];
	}

	//归并排序
	public static void mergeSort(int[] x) {
		int len = x.length;
		for (int n = 1; n < len; n *= 2) {
			mergePass(x, n);
		}
	}
}
