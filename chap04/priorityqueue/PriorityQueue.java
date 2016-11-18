package priorityqueue;

/**
 * 优先队列，以带头结点的有序单链表存储
 * */
public class PriorityQueue<T extends Comparable<T>> {
	private class Node<T> {
		public T value;
		public Node<T> next;

		public Node(T value, Node<T> next) {
			this.value = value;
			this.next = next;
		}

		public Node() {
			this(null, null);
		}
	}

	private Node<T> front; // 头结点
	private final boolean asc; // 是否升序，默认升序

	// 构造方法
	public PriorityQueue(boolean asc) {
		this.asc = asc;
		this.front = new Node<T>();
	}
	public PriorityQueue(){
		this(true);
	}
	public PriorityQueue(T[] values, boolean asc){
		this.asc = asc;
		this.front = new Node<T>();
		for(T value:values)
			enQueue(value);
	}

	// 入队
	public void enQueue(T value){
		Node<T> curr = front;
		if(this.asc){
			for( ; curr.next!=null && curr.next.value.compareTo(value)<=0; curr = curr.next){
				;
			}
			curr.next = new Node<T>(value, curr.next);
		}else{
			for( ; curr.next!=null && curr.next.value.compareTo(value)>=0; curr = curr.next){
				;
			}
			curr.next = new Node<T>(value, curr.next);			
		}
	}
	
	//判断队列是否空
	public boolean isEmpty(){
		return this.front.next == null;
	}
	
	
	//出队
	public T deQueue(){
		T result = null;
		if(isEmpty())
			result = null;
		else{
			result = front.next.value;
			front.next = front.next.next;
		}
		
		return result;
	}
	
	//获取队头元素
	public T peek(){
		if(isEmpty())
			return null;
		else
			return front.next.value;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for(Node<T> curr = front; curr.next!=null; curr = curr.next){
			sb.append(curr.next.value.toString()+" ");
		}
		
		return sb.toString();
	}
}
