package prime;

import java.util.ArrayList;
import java.util.List;

/**
 * 素数筛选法，选出<n的素数
 * */
public class Prime {
	
	public static List<Integer> createPrime(int n) {
		List<Integer> list = new ArrayList<Integer>();
		
		//创建数组(数组有效下标从2开始)，标记下标对应的元素是否为素数
		boolean[] flag = new boolean[n];
		
		//默认元素都为素数
		for (int index = 0; index < n; index++)
			flag[index] = true;
		
		//从2开始，如果flag[index]==true，则flag[index*k]标记为flag;
		//如果flag[index]==false,则直接跳过
		for (int index = 2; index < n; index++) {
			if (flag[index]) {	//当前索引代表的数为素数
				for (int j = index*2; j < n; j += index)
					flag[j] = false;
			} else {
				continue;
			}
		}
		
		//遍历flag数组
		for (int index = 2; index < n; index++) {
			if (flag[index])
				list.add(index);
		}
		
		return list;
	}
	
	public static void main(String[] args) {
		System.out.println(createPrime(500).toString());
	}
}
