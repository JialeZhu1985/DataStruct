package fullBinTree;

public class FullBinaryTree {
	private int size = 0;	// 节点个数
	private int capacity = 0;//	容量
	private int[] nodes = null;	// 数组，存放节点
	
	public FullBinaryTree(int capacity) {
		size = 0;
		this.capacity = capacity;
		nodes = new int[capacity];
	}
	
	public FullBinaryTree() {
		this(16);
	}
	
	//数组扩容
	public void reSize() {
		this.capacity = this.capacity * 2;
		int[] tmp = new int[this.capacity];
		for (int i = 0; i < size; i++) {
			tmp[i] = nodes[i];
		}
		
		nodes = tmp;
	}
	
	//初始化树
	public void init(int[] nums) {		
		for (int i = 0; i < nums.length; i++) {
			if (size == capacity)
				reSize();
			
			nodes[i] = nums[i];
			size++;
		}
	}
	
	//中序遍历
	public void inorder() {
		System.out.println(inorder(0));
	}
	public String inorder(int index) {
		String line = "";
		int left = index * 2 + 1;
		int right = left + 1;
		
		if (left < size)
			line += inorder(left);
		
		line += nodes[index] + ",";
		
		if (right < size)
			line += inorder(right);
		
		return line;
	}
	
	//前序遍历
	public void preOrder() {
		System.out.println(preOrder(0));
	}
	public String preOrder(int index) {
		String line = "";
		int left = index * 2 + 1;
		int right = left + 1;
		
		line += nodes[index] + ",";
		
		if (left < size)
			line += preOrder(left);
		if (right < size)
			line += preOrder(right);
		
		return line;
	}
	
	
	@Override
	public String toString() {
		String line = "[";
		for (int i = 0; i < size; i++)
			line += nodes[i] + ",";
		line += "]";
		return line;
	}
	
}
