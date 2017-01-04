package patternmatching;

/**
 * 字符串的模式匹配
 * 
 * @author panshan
 * @since jdk1.7
 * @version v1.0
 * */
public class BruteForce {
	/**
	 * 返回目标串target从begin开始首个与模式串pattern匹配的子串序号，匹配失败时返回-1。
	 * 对begin容错。若begin<0，则begin=0；若begin序号越界，则查找不成功
	 * 若pattern==null或target==null，则抛出空对象异常
	 * */
	public int indexOf(String target, String pattern, int begin) {
		int res = -1;//返回结果
		
		if(target==null || pattern==null)
			throw new NullPointerException("target==null 或 pattern==null");
		
		if(begin>target.length()-1)//对begin容错
			throw new StringIndexOutOfBoundsException("begin="+begin);
		else if(begin<0)
			begin=0;
		else
			;
		
		int t_len = target.length(), p_len = pattern.length();//获取字符串长度
		int t = begin, p = 0;//字符串索引
		for(t=begin; t<=(t_len-1)-(p_len-1); t++){
			for(p=0; p<p_len; p++){
				if(target.charAt(t+p) == pattern.charAt(p))
					continue;
				else
					break;
			}
			
			if(p==p_len){
				res = t;
				break;
			}
		}
		
		return res;
	}
	
	public int indexOf(String target, String pattern) {
		return this.indexOf(target, pattern, 0);
	}
}
