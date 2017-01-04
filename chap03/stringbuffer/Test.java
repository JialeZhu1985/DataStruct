package stringbuffer;

public class Test {
	public static void main(String[] args) {
		MyStringBuffer msb1 = new MyStringBuffer("asdfghjkl");
		System.out.println(msb1.toString());
		
		msb1.insert(8, "System.out.println(msb1.toString());");
		System.out.println(msb1.toString());
		
		MyStringBuffer msb2 = new MyStringBuffer();
		msb2.insert(0, "System.out.println(msb1.toString());");
		System.out.println(msb2.toString());
		
		msb2.delete(0, 20);
		System.out.println(msb2.toString());
		
		msb2.replace(15, 18, "asdf");
		System.out.println(msb2.toString());
	}
}
