package linkedTree;

public class Test {
	public static void main(String[] args) {
		BinaryTree<Integer> tree = new BinaryTree<>();
		
		//插入根节点
		BinaryNode<Integer> node = tree.insert(0);
		tree.insert(node, 1, true);
		tree.insert(node, 2, false);
		tree.insert(node.left, 3, true);
		tree.insert(node.left, 4, false);
		tree.insert(node.right, 5, true);
		tree.insert(node.right, 6, false);
		tree.insert(node.left.left, 7, true);
		tree.insert(node.left.left, 8, false);
		
		tree.toString();
		
		System.out.println(tree.height());
		System.out.println(tree.size());
		
		Integer[] prelist = new Integer[]{0,1,2,3, null, 4,5,6,7, null, 8};
//		Integer[] prelist = new Integer[]{0,1,3,7,null,null,8,null,null,4,null,null,2,5,null,null,6,null,null};
		BinaryTree<Integer> node2 = new BinaryTree<>(prelist);
		node2.toString();
	}
}
