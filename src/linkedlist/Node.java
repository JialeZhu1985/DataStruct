package linkedlist;

/**
 * 构造链表节点类*/

public class Node {
	public int data;
	public Node next;
	
	public Node(int data, Node next) {
		this.data = data;
		this.next = next;
	}
	
	public Node() {
		this(0, null);
	}
	
	@Override
	public String toString() {
		return this.data+"";
	}
}
