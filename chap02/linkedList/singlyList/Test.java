package linkedList.singlyList;

public class Test {
	
	public static void main(String[] args) {
		String[] strs = {"a", "b", "c", "d", "e"};
		SinglyList<String> sl = new SinglyList<>(strs);
		System.out.println(sl.toString());
		
//		System.out.println(sl.get(0));
//		
//		sl.set(1, "g");
//		System.out.println(sl.toString());
//		sl.set(5, "h");
//		System.out.println(sl.size());
		
		sl.insert(5, "p");
		System.out.println(sl.toString());
		sl.insert(1, "qq");
		System.out.println(sl.toString());
		sl.append("hh");
		System.out.println(sl.toString());
		
		System.out.println(sl.remove(7));
		System.out.println(sl.remove(2));
		System.out.println(sl.remove(7));
		System.out.println(sl.toString());
		
		System.out.println(sl.search("a"));
		System.out.println(sl.search("kk"));
		System.out.println(sl.contains("a"));
		System.out.println(sl.contains("KK"));
//		sl.insert(2, "p");
//		System.out.println(sl.size());
	}
}
