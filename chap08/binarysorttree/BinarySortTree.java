package binarysorttree;

public class BinarySortTree<T extends Comparable<? super T>> {
	public BinaryNode<T> root = null;
	
	//构造方法
	public BinarySortTree() {
		this.root = null;
	}
	
	//判断树是否为空
	public boolean isEmpty() {
		return this.root == null;
	}

	//添加
	public boolean add(T data) {
		BinaryNode<T> curr = root;
		
		BinaryNode<T> parent = null;	// 记录当前节点的父节点
		int cmpres = 0;	// 记录比较结果
		/**
		 * 依次遍历节点，找到data时直接返回false，否则直接退出并获取父节点*/
		while (curr != null) {
			cmpres = data.compareTo(curr.data);
			parent = curr;
			
			if (cmpres < 0)
				curr = curr.left;
			else if (cmpres > 0)				
				curr = curr.right;
			else
				return false;
		}
		
		if (cmpres == 0) {	// 空树
			root = new BinaryNode<T>(data);
		} else if (cmpres < 0) {
			parent.left = new BinaryNode<T>(data);
		} else {
			parent.right = new BinaryNode<T>(data);
		}
		
		return true;
	}
	
	//查找
	public BinaryNode<T> search(T key) {
		BinaryNode<T> curr = root;
		
		while (curr != null) {
			int cmpres = key.compareTo(curr.data);
			
			if (cmpres < 0)
				curr = curr.left;
			else if (cmpres > 0)
				curr = curr.right;
			else
				return curr;
		}
		
		return curr;
	}
	
	
	//递归遍历
	public String inOrder(BinaryNode<T> node) {
		String line = "";
		
		if (node.left != null) 
			line += inOrder(node.left) + ",";
		
		line += node.data.toString() + ",";
		
		if (node.right != null)
			line += inOrder(node.right) + ",";
		
		return line;
	}
}