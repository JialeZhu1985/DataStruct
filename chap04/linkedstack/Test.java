package linkedstack;

public class Test {
	public static void main(String[] args) {
		//构造并初始化栈
		LinkedStack<Integer> ls = new LinkedStack<>();
		System.out.println(ls.isEmpty());
		for(int i=0; i<5; i++)
			ls.push(i);
		System.out.println(ls.toString());
		System.out.println("-----------------------");
		
		//入栈、获取栈顶元素、出栈
		ls.push(5);
		System.out.println(ls.peek());
		System.out.println(ls.pop());
		System.out.println(ls.toString());
		System.out.println("-------------------");
		
		//数组构造栈
		String[] strs = {"a", "s", "d", "f", "g"};
		LinkedStack<String> ls2 = new LinkedStack<>(strs);
		System.out.println(ls2.toString());
	}
}
