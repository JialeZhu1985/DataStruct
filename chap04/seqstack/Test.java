package seqstack;

import java.io.ObjectInputStream.GetField;

public class Test {
	public static void main(String[] args) {
		//创建空栈
		SeqStack<Integer> ss = new SeqStack<>();
		System.out.println(ss.isEmpty());
		//查看栈容量
		System.out.println(ss.getCapacity());
		//入栈
		for(int i=0; i<5; i++)
			ss.push(i);
		//扩容
		ss.increCapacity();
		System.out.println(ss.getCapacity());
		//查看栈元素(自顶向下)
		System.out.println(ss.toString());
		//出栈
		System.out.println(ss.pop());
		//获取栈顶元素
		System.out.println(ss.peek());
		//查看容量
		System.out.println(ss.getCapacity());
		
		//由数组构建栈
		String[] strs = {"a", "s", "d", "f", "g"};
		SeqStack<String> ss2 = new SeqStack<>(strs);
		System.out.println(ss2.toString());
	}
}
