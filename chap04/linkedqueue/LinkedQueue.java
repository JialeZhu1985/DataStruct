package linkedqueue;

/**
 * 链式队列，带头结点 不能带队尾结点，因为如果带尾节点，入队时需要获取尾节点的前一个节点
 * */
public class LinkedQueue<T> {
	private class Node<T> {
		public T value = null;
		public Node<T> next = null;

		public Node(T value, Node<T> next) {
			this.value = value;
			this.next = next;
		}

		public Node() {
			this(null, null);
		}
	}

	private Node<T> front, rear;

	// 构造方法
	public LinkedQueue() {
		front = rear = new Node();
	}

	// 入队
	public void enQueue(T value) {
		Node<T> node = new Node<T>(value, null);
		rear.next = node;
		rear = node;
	}

	// 判断队列是否为空
	public boolean isEmpty() {
		return front == rear;
	}

	// 出队
	public T deQueue() {
		T result = null; // 返回值

		if (isEmpty()) { // 如果是空队列，返回值为null
			result = null;
		} else if (front.next == rear) { // 如果是最后一个节点，删除节点，并将rear指向front，变成空队列
			result = front.next.value;
			rear = front; // 队列空
			front.next = null;
		} else { // 如果不是最后一个节点，直接删除front后一个节点，front后移
			result = front.next.value;
			front.next = front.next.next;
		}

		return result;
	}

	// 获取队列头元素
	public T peek() {
		if (isEmpty())
			return null;
		else
			return front.next.value;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		
		Node<T> curr = front;
		while (curr.next != null) {
			sb.append(curr.next.value.toString()+" ");
			curr = curr.next;
		}
		
		return sb.toString();
	}
}
