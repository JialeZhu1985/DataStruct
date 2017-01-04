package linkedTree;

public class BinaryNode<T> {
	private T data;		// 数据域
	public BinaryNode<T> left, right;	//	地址域
	
	//构造方法
	public BinaryNode(T data, BinaryNode<T> left, BinaryNode<T> right) {
		this.data = data;
		this.left = left;
		this.right = right;
	}
	
	public BinaryNode(T data) {
		this(data, null, null);
	}
	
	public boolean isLeaf() {
		return this.left == null && this.right == null;
	}
	
	@Override
	public String toString() {
		return this.data.toString();
	}
}
