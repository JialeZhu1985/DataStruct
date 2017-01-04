package recursion;

/**
 * 递归创建单链表、遍历单链表
 * */
public class SinglyList<T> {
	private class Node<T>{
		public T value;
		public Node<T> next = null;
		
		public Node(T value, Node<T> next){
			this.value = value;
			this.next = next;
		}
		public Node(){
			this(null, null);
		}
	}
	
	private Node<T> head;
	
	public SinglyList(){
		head = new Node<T>();
	}
	public SinglyList(T[] values){
		this();
		head.next = create(values, 0);
	}
	
	public Node<T> create(T[] values, int start){
		Node<T> node = null;
		if(start<values.length){
			node = new Node<T>(values[start], null);
			node.next = create(values, ++start);
		}
		return node;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		return toString(head);
	}
	public String toString(Node<T> curr){
		if(curr.next==null)
			return "";
		else{
			String str = curr.next.value.toString();
			return str+"-"+toString(curr.next);			
		}
	}
}
