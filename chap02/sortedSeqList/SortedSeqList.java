package sortedSeqList;

import seqList.SeqList;

public class SortedSeqList<T extends Comparable<? super T>> extends SeqList<T> {
	public SortedSeqList() {
		super();
	}
	public SortedSeqList(int length){
		super(length);
	}
	public SortedSeqList(T[] values){
		super(values.length);
		for(T item:values)
			this.insert(item);
	}
	
	//覆盖父类的插入操作
	@Override
	public void insert(int index, T value) {
		throw new UnsupportedOperationException("insert(int index, T value)");
	}
	@Override
	public void insert(T value) {
		int i=0;
		if(isEmpty() || value.compareTo(this.get(this.used-1))>0)
			i = this.used;
		else
			while(i<this.used && value.compareTo(this.get(i))>0)
				i++;
		super.insert(i, value);
	}
	
	//覆盖父类的set()方法
	@Override
	public void set(int index, T value) {
		throw new UnsupportedOperationException("set(int index, T value)");
	}
	
	//覆盖父类的search()方法
	@Override
	public int search(T key) {
		int index = -1;
		for(int i=0; i<this.used && key.compareTo(this.get(i))>=0; i++)
			if(key.compareTo(this.get(i))==0){
				index = i;
				break;				
			}
		
		return index;
	}
	
	//删除首次出现的指定元素
	public T remove(T key){
		return this.remove(search(key));
	}
}
