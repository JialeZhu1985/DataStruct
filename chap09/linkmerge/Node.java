package linkmerge;

public class Node<T> {
	//成员变量
	public T value;
	public Node<T> next;
	
	//构造方法
	public Node(T value, Node<T> next){
		this.value = value;
		this.next = next;
	}
	public Node(){
		this(null, null);
	}
	
	@Override
	public boolean equals(Object obj) {
		Node<T> node = (Node<T>)obj;
		return this.value.equals(node.value);
	}
	
	@Override
	public String toString() {
		return this.value.toString();
	}
}
