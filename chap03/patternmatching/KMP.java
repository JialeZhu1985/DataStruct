package patternmatching;

public class KMP {
	
	public int[] getNext(String pattern){
		/**
		 * 初始化next数组
		 * */
		int[] next = new int[pattern.length()];
		next[0] = -1;
		
		int p = 0;//pattern字符串索引
		int k = -1;//相同前后缀子串长度
		
		while(p<pattern.length()-1){
			if(k==-1 || pattern.charAt(p)==pattern.charAt(k)){
				k++;
				p++;
				next[p] = k;
			}else
				k = next[k];
		}
		return next;
	}
	
	/**
	 * 模式匹配
	 * */
	public int indexOf(String target, String pattern){
		int res = -1;
		
		//空指针检查
		if(target==null || pattern==null)
			throw new NullPointerException("target==null || pattern==null");
		
		int t_len = target.length(), p_len = pattern.length();//获取字符串长度
		
		//空字符串检查
		if(t_len==0 || p_len==0){
			return -1;
		}
		
		int p = 0, t = 0;//字符串当前下标
		int[] next = getNext(pattern);
		
		while(t<t_len && p<p_len){
			if(p==-1 || target.charAt(t)==pattern.charAt(p)){//若当前两个字符相等
				t++;
				p++;
			}else{
				p = next[p];
				if(t_len-t+1<p_len-p+1)
					break;
			}
		}
		
		if(p==p_len)
			return t-p;
		else
			return -1;
	}
}
