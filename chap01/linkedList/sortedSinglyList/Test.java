package linkedList.sortedSinglyList;

public class Test {
	public static void main(String[] args) {
		String[] strs = {"cc", "dd", "aa", "ee", "qq", "hh"};
		SortedSinglyList<String> ssl = new SortedSinglyList<>(strs);
		System.out.println(ssl.toString());
		ssl.insert("c");
		System.out.println(ssl.toString());
		
		System.out.println(ssl.search("dd"));
		System.out.println(ssl.search("ll"));
		System.out.println(ssl.remove("dd"));
		System.out.println(ssl.toString());
		System.out.println(ssl.remove("ff"));
		System.out.println(ssl.toString());
	}
}
