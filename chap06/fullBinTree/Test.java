package fullBinTree;

public class Test {
	public static void main(String[] args) {
		FullBinaryTree tree = new FullBinaryTree(8);
		tree.init(new int[]{0,1,2,3,4,5,6,7,8,9});
		System.out.println(tree.toString());
		tree.inorder();
		tree.preOrder();
	}
}
