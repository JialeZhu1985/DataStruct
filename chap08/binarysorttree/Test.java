package binarysorttree;

import java.util.Random;

public class Test {
	public static void main(String[] args) {
		BinarySortTree<Integer> bt = new BinarySortTree<>();
		
		Random r = new Random();
		for (int i = 10; i > 0; i--) {
			System.out.println(bt.add(r.nextInt(30)));
		}
		
		System.out.println(bt.inOrder(bt.root));
	}
}
