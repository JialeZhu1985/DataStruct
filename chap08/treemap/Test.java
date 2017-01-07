package treemap;

public class Test {
	public static void main(String[] args) {
		MyTreeMap<Integer, Character> tm = new MyTreeMap<>();
		
		for (int i = 0; i < 10; i++) {
			tm.put(i, (char)('z' - i));
		}
		
		System.out.println(tm.toString());
		System.out.println("**********************");
		
		System.out.println(tm.put(9, 'c'));
		System.out.println(tm.put(11, 'x'));
		
		System.out.println(tm.get(6));
		System.out.println(tm.toString());
	}
}
