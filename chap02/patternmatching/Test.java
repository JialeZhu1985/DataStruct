package patternmatching;

public class Test {
	public static void main(String[] args) {
		String target = "asdfghjk";
		String pattern = "dfghjk";
		
//		BruteForce bf = new BruteForce();
//		System.out.println(bf.indexOf(target, pattern, 0));
		KMP kmp = new KMP();
		pattern = "abcabdabcabcaa";
//		int[] res = kmp.getNext(pattern);
//		for(int item:res)
//			System.out.println(item);
		target = "acabbabbabc";
		pattern = "abbabc";
		System.out.println(kmp.indexOf(target, pattern));
	}
}
