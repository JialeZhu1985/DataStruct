package string;

import java.io.Serializable;

/**
 * 构造常量字符串类，顺序存储
 * 
 * @author panshan
 * @since jdk1.7
 * @version v1.0
 * */
public class MyString implements Serializable, Comparable<MyString> {
	private final char[] value; // 字符数组，存储最终变量

	// 构造方法
	public MyString() { // 构造空字符串
		this.value = new char[0];
	}

	public MyString(char[] value, int start, int len) { // 由字符数组构造字符串，指定字符数组起始位置、长度
		// 首先进行索引范围检查
		if (start < 0 || start + len > value.length) {
			throw new IndexOutOfBoundsException("start=" + start + ", len="
					+ len);
		} else {
			this.value = new char[len];
			for (int index = 0; index < len; index++) {
				this.value[index] = value[start + index];
			}
		}
	}

	public MyString(char[] value, int start) {
		this(value, start, value.length - start);
	}

	public MyString(char[] value) {
		this(value, 0, value.length);
	}

	public MyString(String str) {
		this.value = new char[str.length()];
		for (int index = 0; index < str.length(); index++)
			this.value[index] = str.charAt(index);
	}

	// 获取字符串长度
	public int length() {
		return this.value.length;
	}

	// 返回指定索引处的字符
	public char charAt(int index) {
		if (index < 0 || index > length())
			throw new IndexOutOfBoundsException("index=" + index);
		else
			return this.value[index];
	}

	// 求子串
	public MyString substring(int begin, int end) {
		return new MyString(this.value, begin, end - begin); // 已经包含索引越界检查
	}

	public MyString substring(int begin) {
		return substring(begin, this.value.length);
	}

	// 连接串
	public MyString concat(MyString str) {
		if (str == null) // 目标串为null时，插入字符串"null"
			str = new MyString("null");

		char[] temp = new char[this.length() + str.length()];
		for (int index = 0; index < this.length(); index++)
			temp[index] = this.charAt(index);
		for (int index = 0; index < str.length(); index++)
			temp[this.length() + index] = str.charAt(index);

		return new MyString(temp);
	}

	// 串比较
	@Override
	public int compareTo(MyString str) {
		int len1 = this.length(), len2 = str.length();
		int index = 0;
		int res=0;
		
		while(index<len1 && index<len2){
			res = this.charAt(index)-str.charAt(index);
			if(res==0)			//字符相等时，比较后续字符
				index++;
			else					//遇到不等字符，则停止比较，直接返回
				return res;
		}
		
		//其中一个字符是另一个字符子串的情况下，返回串长度差
		return len1-len2;

	}

	@Override
	public String toString() {
		return new String(this.value);
	}
}
