package recursion;

/**
 * 辗转相除法的递归实现，求两个数的最大公约数
 * */
public class GCD {
	public int gcd(int a, int b){
		if(b==0)
			return a;
		else
			return gcd(b, a%b);
	}
	
	public static void main(String[] args) {
		System.out.println(new GCD().gcd(56, 21));
	}
}
