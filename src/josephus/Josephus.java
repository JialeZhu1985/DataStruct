package josephus;

import java.util.List;
import java.util.ArrayList;

/**
 * 约瑟夫环问题
 * 1)创建具有number个元素的表对象
 * 2)从第start个元素开始数数，每数到第step个元素，就将该元素删除
 * 3)重复计数并删除元素，直到剩余一个元素*/

public class Josephus {
	public static void josephus(int number, int start, int step) {
		//定义环，并初始化
		List<Character> list = new ArrayList<>(number);
		for (int i = 0; i < number; i++)
			list.add((char)('a'+i));
		System.out.println(list.toString());
		
		int index = start;
		while (number > 1) {
			index = (index + step - 1) % number;	//待删除元素的索引
			number--;
			System.out.println(list.remove(index));
		}
		System.out.println("-------------------");
		System.out.println(list.toString());
	}
	
	public static void main(String[] args) {
		josephus(10, 2, 4);
	}
}
