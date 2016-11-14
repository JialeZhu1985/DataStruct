package integer;

public class Test {
	public static void main(String[] args) {
		MyInteger num = new MyInteger(10);
		System.out.println(num.toString());
		
		MyInteger num2 = new MyInteger("-12");
		System.out.println(num2.toString());
		
		MyInteger num3 = new MyInteger("-aBc", 16);
		System.out.println(num3.toString());
		
//		MyInteger num4 = new MyInteger("-aBFG", 16);
//		System.out.println(num4.toString());
		System.out.println(num3.toHexString());
	}
}
