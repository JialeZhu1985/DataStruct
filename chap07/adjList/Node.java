package adjList;

/**
 * 边链表节点类
 * */
public class Node<Triple> {
	public Triple data;
	public Node<Triple> next;
	
	public Node(Triple data, Node<Triple> next) {
		this.data = data;
		this.next = next;
	}
	
	public Node() {
		this(null, null);
	}
	
	@Override
	public String toString() {
		return data.toString();
	}
}