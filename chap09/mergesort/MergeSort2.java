package mergesort;

/**
 * 归并排序算法：自顶向下递归排序*/
public class MergeSort2 {
	//合并操作，根据索引合并两个子序列
	public static void merge2(int[] x, int start, int mid, int end) {
		int[] tmp = new int[end - start + 1];
		int index1 = start, index2 = mid + 1, index = 0;
		
		while (index1 <= mid && index2 <= end) {
			if (x[index1] < x[index2])
				tmp[index++] = x[index1++];
			else
				tmp[index++] = x[index2++];
		}
		
		while (index1 <= mid)
			tmp[index++] = x[index1++];
		while (index2 <= end)
			tmp[index++] = x[index2++];
		
		//移动数组元素
		for (int i = 0; i < tmp.length; i++)
			x[start + i] = tmp[i];
	}

	//拆分排序
	public static void sort2(int[] x, int start, int end) {
		if (start < end) {	//递归进行的条件
			int mid = (start + end) / 2;
			
			sort2(x, start, mid);
			sort2(x, mid + 1, end);
			merge2(x, start, mid, end);
		}
	}

	public static void mergeSort2(int[] x) {
		sort2(x, 0, x.length - 1);
	}
}
