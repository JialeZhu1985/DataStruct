package integer;

import java.io.Serializable;

public class MyInteger implements Comparable<MyInteger>, Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static final int MIN_VALUE = 0x80000000;
	public static final int MAX_VALUE = 0x7fffffff;
	public final int value;
	
	//构造方法
	public MyInteger(int value) {
		this.value = value;
	}
	public MyInteger(String str, int radix){
		this.value = parseInt(str, radix);
	}
	public MyInteger(String str){
		this.value = parseInt(str, 10);
	}
	
	//字符串解析为整型数值
	public int parseInt(String str, int radix){
		if(str==null)
			throw new NumberFormatException("str==null");
		else if(radix<2 || radix>16)
			throw new NumberFormatException("进制超出范围，radix="+radix);
		else{
			int sign = str.charAt(0)=='-'?-1:1;		//符号位
			int value=0;										//最终解析的数值
			int index = 0;									//字符串索引
			
			if(str.charAt(0)=='-' || str.charAt(0)=='+')	//跳过符号位
				index++;
			
			while(index<str.length()){
				char ch = str.charAt(index++);			//获取指定索引的字符
				
				if('0'<=ch && ch<='9'){
					if(ch-'0'<radix)
						value = value*radix+(ch-'0');
					else
						throw new NumberFormatException(ch+">"+radix);
				}else if('A'<=ch && ch<='Z'){
					if(ch-'A'<radix-10)
						value = value*radix+(ch-'A'+10);
					else
						throw new NumberFormatException(ch+">"+radix);
				}else if('a'<=ch && ch<='z'){
					if(ch-'a'<radix-10)
						value = value*radix+(ch-'a'+10);
					else
						throw new NumberFormatException(ch+">"+radix);
				}else
					throw new NumberFormatException("ch="+ch);
			}
			return value*sign;
		}
	}
	
	//整型解析为十六进制形式补码的字符串
	public String toHexString(){
		char[] buffer = new char[8];
		int value = this.value;
		
		for(int i = 0; i<8; i++){
			int tmp = value&15;
			
			if(tmp<10)
				buffer[buffer.length-1-i] = (char)(tmp+'0');
			else
				buffer[buffer.length-1-i] = (char)(tmp-10+'A');
			
			value = value>>>4;
		}
		
		return new String(buffer);
	}
	
	@Override
	public int compareTo(MyInteger o) {
		return this.value - o.value;
	}
	
	@Override
	public String toString() {
		return new String("max="+MAX_VALUE+",min="+MIN_VALUE+",value="+value);
	}
}