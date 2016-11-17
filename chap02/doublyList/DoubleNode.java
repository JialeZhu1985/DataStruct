package doublyList;

public class DoubleNode<T> {
	public T value;
	public DoubleNode<T> pre, next;
	
	//构造方法
	public DoubleNode(T value, DoubleNode<T> pre, DoubleNode<T> next){
		this.value = value;
		this.pre = pre;
		this.next = next;
	}
	public DoubleNode(){
		this(null, null, null);
	}
	
	@Override
	public String toString() {
		return this.value.toString();
	}
}
