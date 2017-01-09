package brute_force;

/**
 * 串的模式匹配Brute-Force算法：将目标串中字符ti与模式串中字符pj进行比较，若比较成功则两个索引同时后移，若比较失败则i回溯
 * */
public class BruteForce {
	public static int indexOf(String target, String pattern) {
		//首先，获取目标串和模式串的长度，并确定长度关系是否满足条件
		int tlen = target.length();
		int plen = pattern.length();
		if (tlen < plen)
			return -1;
		
		//定义目标串和模式串的移动索引
		int t = 0, p = 0;
		
		while (t < tlen && p < plen) {
			if (target.charAt(t) == pattern.charAt(p)) {	//如果对应字符相等，则索引同时后移
				t++;
				p++;
			} else {	//如果对应字符不相等，则target的索引回溯，pattern的索引从0开始
				t = t - p + 1;
				p = 0;
			}
		}
		
		//匹配成功时，索引p到头，即p==plen
		if (p == plen)
			return t - plen;
		else
			return -1;
	}
	
	public static void main(String[] args) {
		String target = "qwertyuiop";
		String pattern= "erty";
		System.out.println(indexOf(target, pattern));
	}
}
