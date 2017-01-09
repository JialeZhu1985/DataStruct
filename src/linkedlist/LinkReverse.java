package linkedlist;

public class LinkReverse {
	public static void main(String[] args) {
		Linked link = new Linked();
		for (int i = 0; i < 10; i++)
			link.append(i);
		System.out.println(link.toString());
	}
}
