package linklist;

/**
 * 构造链表类，带头结点*/

public class Linked {
	public Node head = null;
	
	public Linked() {
		head = new Node();
	}
	
	public void append(int data) {
		Node curr = head;
		while (curr.next != null) {
			curr = curr.next;
		}
		
		curr.next = new Node(data, null);
	}
	
	@Override
	public String toString() {
		Node curr = head.next;
		StringBuffer sb = new StringBuffer();
		
		while (curr != null) {
			sb.append(curr.toString()+",");
			curr = curr.next;
		}
		
		return sb.toString();
	}
}