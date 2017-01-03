package linkedTree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BinaryTree<T> {
	private BinaryNode<T> root = null;
	
	//构造方法
	public BinaryTree() {
		this.root = null;
	}
	
	public BinaryTree(T[] prelist) {
		this.root = create(prelist);
	}
	
	private int index = 0;
	private BinaryNode<T> create(T[] prelist) {
		BinaryNode<T> node = null;
		if (index < prelist.length) {
			T ele = prelist[index++];
			
			if (ele != null) {
				node = new BinaryNode<T>(ele);
				node.left = create(prelist);
				node.right = create(prelist);
			} else {
				;
			}
		}
		
		return node;
	}
	
	//判断是否为空树
	public boolean isEmpty() {
		return root == null;
	}
	
	//插入节点作为根节点,原节点作为左孩子节点
	public BinaryNode<T> insert(T data) {
		return this.root = new BinaryNode<T>(data,root, null);
	}
	
	//插入节点data作为parent的子节点
	public BinaryNode<T> insert(BinaryNode<T> parent, T data, boolean leftChild) {
		if (data == null)
			return null;
		else if (leftChild) {
			return parent.left = new BinaryNode<T>(data, parent.left, null);
		} else
			return parent.right = new BinaryNode<T>(data, null, parent.right);
	}
	
	//删除parent节点的一个子树
	public void remove(BinaryNode<T> parent, boolean leftChild) {
		if (leftChild) {
			parent.left = null;
		} else
			parent.right = null;
	}
	
	//删除所有节点
	public void clear() {
		root = null;
	}
	
	//遍历二叉树
	public String toString() {
		System.out.println(preOrder(root));
		System.out.println(inOrder(root));
		System.out.println(postOrder(root));
		
		return null;
	}
	
	public String preOrder(BinaryNode<T> node) {
		String line = "";
		
		if (node == null) {
			line += "^";
		} else {
			line += node.toString() + ",";
			line += preOrder(node.left);
			line += preOrder(node.right);
		}
		
		return line;
	}
	
	public String inOrder(BinaryNode<T> node) {
		String line = "";
		
		if (node == null) {
			line += "^";
		} else {
			line += inOrder(node.left);
			line += node.toString() + ",";
			line += inOrder(node.right);
		}
		
		return line;
	}
	
	public String postOrder(BinaryNode<T> node) {
		String line = "";
		
		if (node == null) {
			line += "^";
		} else {
			line += postOrder(node.left);
			line += postOrder(node.right);
			line += node.toString() + ",";
		}
		
		return line;
	}
	
	//返回树的高度
	public int height() {
		int height = 0;
		BinaryNode<T> node = root;
		
		while (node != null) {
			height++;
			node = node.left;
		}
		
		return height;
	}
	
	//返回树的节点数
	public int size() {
		return size(root);
	}
	
	public int size(BinaryNode<T> node) {
		int size = 0;
		
		if (node == null) {
			;
		} else {
			size += size(node.left);
			size++;
			size += size(node.right);
		}
		
		return size;
	}
	
	//非递归先跟次序遍历
	public void preOrderTraverse() {
		Stack<BinaryNode<T>> stack = new Stack<>();
		BinaryNode<T> p = root;
		
		while (p != null || !stack.isEmpty()) {
			if (p != null) {
				System.out.println(p.toString());
				stack.push(p);
				p = p.left;
			} else {//p==null && !stack.isEmpty()
				p = stack.pop();
				p = p.right;
			}
		}
	}
	public void inOrderTraverse() {
		Stack<BinaryNode<T>> stack = new Stack<>();
		BinaryNode<T> p = root;
		
		while (p != null || !stack.isEmpty()) {
			if (p != null) {
				stack.push(p);
				p = p.left;
			} else {	//p==null && !stack.isEmpty()
				p = stack.pop();
				System.out.println(p.toString());
				p = p.right;
			}
		}
	}
	
	//层次遍历
	public void levelorder() {
		Queue<BinaryNode<T>> queue = new LinkedList<BinaryNode<T>>();
		BinaryNode<T> p = root;
		
		while (p != null) {
			System.out.println(p.toString());
			
			if (p.left != null)
				queue.add(p.left);
			if (p.right != null)
				queue.add(p.right);
			
			p = queue.poll();//队列空时返回null
		}
	}
}
