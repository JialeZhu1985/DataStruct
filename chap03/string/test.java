package string;

public class test {
	public static void main(String[] args) {
		char[] tmp = new char[]{'a', 's', 'd', 'f', 'g', 'h' ,'e'};
		MyString ms = new MyString(tmp);
//		MyString ms2 = new MyString(tmp, 1, 7);
		System.out.println(ms.toString());
		
		System.out.println(ms.charAt(0));
		System.out.println(ms.charAt(6));
//		System.out.println(ms.charAt(7));
		
		System.out.println(ms.substring(1));
		System.out.println(ms.substring(1, 6));
		
		MyString ms2 = new MyString(tmp);
		System.out.println(ms.concat(ms2).toString());
		
		System.out.println(ms.compareTo(ms.concat(ms2)));
	}
}
