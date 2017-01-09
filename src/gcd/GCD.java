package gcd;

/**
 * 辗转相除法求最大公约数
 * 递推通式：
 * 	gcd(a, b) = gcd(b, a%b)
 * 	gcd(a, 0) = |a|
 * 	gcd(a, b) = gcd(b, a)
 * 	gcd(a, -b)=	gcd(a, b)
 * 
 * 辗转相除法求最小公倍数
 * 假设整数A、整数B最大公约数为C,则分解A、B：
 * 	A = a * C
 * 	B = b * C
 * 所以A、B最小公倍数为min = A*B/C
 * */
public class GCD {
	//递归实现
	public static int gcd1(int a, int b) {
		if (b != 0)
			return gcd1(b, a%b);
		else
			return Math.abs(a);
	}
	
	//非递归实现
	public static int gcd2(int a, int b) {
		while (b != 0) {
			int tmp = a%b;
			a = b;
			b = tmp;
		}
		
		return Math.abs(a);
	}
	
	//最小公倍数
	public static int minGCD(int a, int b) {
		int gcd = gcd1(a, b);	//最大公约数
		int mul = a * b;		//两数乘积
		
		return mul/gcd;
	}
	
	public static void main(String[] args) {
		System.out.println(gcd1(12375, -26460));
		System.out.println(gcd2(-12375, 26460));
		System.out.println(minGCD(12375, -26460));
	}
}
