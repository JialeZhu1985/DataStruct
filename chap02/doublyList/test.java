package doublyList;

public class test {
	public static void main(String[] args) {
		String[] str = {"ss", "dd", "ff", "aa", "hh"};
		DoubleLinkedList<String> dll = new DoubleLinkedList<>(str);
		
		System.out.println(dll.toString());
		System.out.println(dll.revString());
		
		dll.insert(1, "qq");
		System.out.println(dll.toString());
		dll.insert(-1, "q");
		System.out.println(dll.toString());
		dll.insert(7, "pq");
		System.out.println(dll.toString());
		
		System.out.println("--------------");
		System.out.println(dll.remove(1));
		System.out.println(dll.toString());
		System.out.println(dll.remove(0));
		System.out.println(dll.toString());
		System.out.println(dll.remove(6));
		System.out.println(dll.toString());
	}
}
