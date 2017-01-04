package hashtable;

import java.util.ArrayList;

/**
 * 构造链地址法的散列表
 * @author PanShan
 * */
public class MyHashSet<T> {
	public int len;
	public ArrayList<T>[] table = null;
	
	//构造方法
	public MyHashSet(int len) {
		this.len = len;
		this.table = new ArrayList[this.len];
		
		for (int i = 0; i < this.len; i++)
			this.table[i] = new ArrayList<T>();
	}
	public MyHashSet() {
		this(10);
	}
	
	//计算元素关键字的散列地址，元素为null时抛出异常
	private int hash(T t) {
		int key = Math.abs(t.hashCode());
		return key % this.len;
	}
	
	//添加元素
	public boolean add(T t) {
		int index = hash(t);	//获取对应的行索引
		
		if (this.table[index].contains(t))
			return false;
		else {
			this.table[index].add(t);
			return true;
		}
	}

	//判断指定元素是否存在
	public boolean contains(T key) {
		int index = hash(key);	//获取关键字对应的行索引
		
		return table[index].contains(key);
	}
	
	//删除指定元素
	public boolean remove(T t) {
		int index = hash(t);
		
		if (this.table[index].contains(t)) {
			this.table[index].remove(t);
			return true;
		} else
			return false;
	}
	
	//遍历
	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		
		for (ArrayList<T> arrlist : table) {
			if (arrlist.size() > 0)
				sb.append(arrlist.toString()+"\n");
		}
		
		return sb.toString();
	}
}
