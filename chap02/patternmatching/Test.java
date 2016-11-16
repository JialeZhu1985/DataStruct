package patternmatching;

public class Test {
	public static void main(String[] args) {
		String target = "asdfghjk";
		String pattern = "dfghjk";
		
		BruteForce bf = new BruteForce();
		System.out.println(bf.indexOf(target, pattern, 0));
	}
}
