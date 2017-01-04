package stringbuffer;

import java.io.Serializable;

/**
 * 自定义可变字符串类
 * 
 * @author panshan
 * @since jdk1.7
 * @version v1.0
 * */
public class MyStringBuffer implements Serializable {
	private static final long serialVersionUID = 1L;
	private char[] values;
	private int used;

	// 构造方法
	public MyStringBuffer(int capacity) {
		this.values = new char[capacity];
		this.used = 0;
	}

	public MyStringBuffer() {
		this(16);
	}

	public MyStringBuffer(String str) {
		this(str.length() + 16);
		for (int index = 0; index < str.length(); index++) {
			this.values[index] = str.charAt(index);
			this.used++;
		}
	}

	// 获取字符串长度
	public int length() {
		return this.used;
	}

	// 返回字符数组容量
	public int capacity() {
		return this.values.length;
	}

	// 在指定索引开始处插入字符串
	public synchronized void insert(int i, String str) {
		if (i >= 0 && i <= this.used) {
			if (this.used + str.length() > this.capacity()) { // 扩容
				char[] tmp = new char[(this.used + str.length()) * 2];

				for (int index = 0; index < this.used; index++)
					tmp[index] = this.values[index];

				this.values = tmp;
			}

			for (int index = this.used - 1; index >= i; index--) {
				this.values[index + str.length()] = this.values[index];
			}
			for (int index = 0; index < str.length(); index++) {
				this.values[i + index] = str.charAt(index);
			}
			this.used += str.length();
		} else {
			throw new StringIndexOutOfBoundsException("i=" + i);
		}
	}

	// 删除子串,[begin, end)
	public synchronized void delete(int begin, int end) {
		if (0 <= begin && begin < end) {
			if (end > length()) // end容错
				end = length();
			for (int index = 0; index < this.length() - end; index++) { // 移动元素
				this.values[begin + index] = this.values[end + index];
			}
			this.used -= end - begin;
		} else
			throw new StringIndexOutOfBoundsException("begin=" + begin
					+ ",end=" + end);
	}

	// 替换子串 [begin, end)
	public void replace(int begin, int end, String str) {
		if (str == null) // 判断字符串是否有效
			throw new NullPointerException("str=null");

		if (0 <= begin && begin < end) {
			if (end > length()) // 对end容错
				end = length();
			
			/*
			 * 先计算移动元素的偏移量，偏移量可正可负，取决于str.length()与(end-begin)的差值。
			 * 偏移量为正时，元素后移；偏移量为负时，元素前移
			 * */
			int offset = str.length() - (end-begin);
			if(offset>0){//先把元素后移，然后替换
				for(int index=length()-1; index>=end; index--)
					this.values[index+offset] = this.values[index];
				for(int index=0; index<str.length(); index++)
					this.values[begin+index] = str.charAt(index);
				this.used += offset;
			}else{//先替换，然后往前移动元素
				for(int index=0; index<str.length(); index++)
					this.values[begin+index] = str.charAt(index);
				for(int index=end; index<length(); index++)
					this.values[offset+index] = this.values[index];
				this.used += offset;
			}
		} else
			throw new StringIndexOutOfBoundsException("begin=" + begin
					+ ",end=" + end);
	}

	@Override
	public synchronized String toString() {
		return new String(this.values, 0, this.used);
	}
}
