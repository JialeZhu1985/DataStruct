package linkmerge;

import java.util.Random;

public class Test {
	public static void main(String[] args) {
		SortedSinglyList<Integer> ssl1 = new SortedSinglyList<>();
		SortedSinglyList<Integer> ssl2 = new SortedSinglyList<>();
		
		Random r = new Random();
		for (int i = 0; i < 10; i++)
			ssl1.insert(r.nextInt(30));
		for (int i = 0; i < 15; i++)
			ssl2.insert(r.nextInt(30));
		
		System.out.println(ssl1.toString());
		System.out.println(ssl2.toString());
		
		Merge.merge2(ssl1, ssl2);
		System.out.println(ssl1.toString());
		System.out.println(ssl2.toString());
	}
}
