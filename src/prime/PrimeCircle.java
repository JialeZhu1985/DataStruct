package prime;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

/**
 * 素数环问题
 * */
public class PrimeCircle {
	//当素数环最大元素为n时，素数和上界为2*n,即找出2*n以内的素数
	public static void primeCircle(int n) {
		//首先，获取2*n以内的素数集合
		List<Integer> list = Prime.createPrime(2*n);
		
		//创建Stack，存放素数环
		Stack<Integer> stack = new Stack<>();
		
		//创建队列，存放n以内数字
		Queue<Integer> numbers = new LinkedList<Integer>();
		
		//初始化numbers队列
		for (int i = 1; i <= n; i++)
			numbers.add(i);
		
		stack.push(numbers.poll());
		while (numbers.size() > 0){
			if (list.contains(stack.peek()+numbers.peek())) {
				stack.push(numbers.poll());
			} else {
				Integer e = numbers.poll();
				numbers.add(e);
			}
		}
		
		System.out.println(stack.toString());
	}
	
	public static void main(String[] args) {
		primeCircle(10);
	}
}
