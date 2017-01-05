package binarysorttree;

public class BinaryNode<T> {
	public T data = null;
	public BinaryNode<T> left = null, right = null;
	
	//构造方法
	public BinaryNode(T data, BinaryNode<T> left, BinaryNode<T> right) {
		this.data = data;
		this.left = left;
		this.right = right;
	}
	public BinaryNode(T data) {
		this(data, null, null);
	}
	
	@Override
	public String toString() {
		return data.toString();
	}
}
