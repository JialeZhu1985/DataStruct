package linkedstack;

/**
 * 链式栈
 * */
public class LinkedStack<T> {
	private class Node<T>{
		public T value;
		public Node<T> next;
		
		public Node(){
			value = null;
			next = null;
		}
	}
	
	public Node<T> head;
	
	//构造方法
	public LinkedStack(){
		head = new Node<T>();
	}
	public LinkedStack(T[] values){	//头插入
		head = new Node<T>();
		for(T value:values){
			Node<T> node = new Node<T>();
			node.value = value;
			node.next = head.next;
			
			head.next = node;
		}
	}
	
	//入栈
	public void push(T t){
		Node<T> node = new Node<>();
		node.value = t;
		node.next = head.next;
		
		head.next = node;
	}
	
	//出栈
	public T pop(){
		T t = head.next.value;
		head.next = head.next.next;
		
		return t;
	}
	
	//获取栈顶元素
	public T peek(){
		return head.next.value;
	}
	
	//判断空栈
	public boolean isEmpty(){
		return head.next==null;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		Node<T> curr = head;
		while(curr.next != null){
			sb.append(curr.next.value+" ");
			curr = curr.next;
		}
		
		return sb.toString();
	}
}
