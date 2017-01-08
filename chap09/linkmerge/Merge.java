package linkmerge;
import java.util.Random;

public class Merge {
	
	//ssl2归并到ssl1
	public static void merge1(SortedSinglyList<Integer> ssl1, SortedSinglyList<Integer> ssl2) {
		Node<Integer> p1 = ssl1.head.next, p2 = ssl2.head.next, p = new Node<Integer>(), head = p;
		while (p1 != null && p2 != null) {
			int cmp = p1.value.compareTo(p2.value);
			if (cmp < 0) {
				p.next = p1;
				p = p.next;
				p1 = p1.next;
			} else {
				p.next = p2;
				p = p.next;
				p2 = p2.next;
			}
		}
		
		if (p1 != null)
			p.next = p1;
		if (p2 != null)
			p.next = p2;
		
		ssl1.head = head;
	}
	
	public static void merge2(SortedSinglyList<Integer> ssl1, SortedSinglyList<Integer> ssl2) {
		Node<Integer> parent = ssl1.head, curr1 = ssl1.head.next, curr2 = ssl2.head.next;
		while (curr1 != null && curr2 != null) {
			int cmp = curr1.value.compareTo(curr2.value);
			if (cmp <= 0) {
				parent = curr1;
				curr1 = curr1.next;
			} else {
				parent.next = curr2;
				parent = parent.next;

				curr2 = curr2.next;
				parent.next = curr1;				
			}
		}
		
		if (curr2 != null)
			curr1 = curr2;
	}
}
