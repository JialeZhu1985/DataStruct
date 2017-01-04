package hashtable;

public class Test {
	public static void main(String[] args) {
		Character[] chs = new Character[]{'q','w','e','r','t','y','u','i'};
		MyHashSet<Character> hashset = new MyHashSet<>(6);
		
		for (Character ch : chs)
			hashset.add(ch);
		System.out.println(hashset.toString());
		System.out.println("-----------------");
		
		System.out.println(hashset.contains('e'));
		System.out.println(hashset.contains('f'));
		System.out.println("------------------");
		
		System.out.println(hashset.add('f'));
		System.out.println(hashset.add('f'));
		System.out.println(hashset.remove('q'));
		System.out.println(hashset.remove('q'));
		System.out.println("-------------------");
		
		System.out.println(hashset.toString());
		
	}
}
