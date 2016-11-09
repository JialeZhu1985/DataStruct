package seqList;

/**
 * 顺序表类的实现
 * @author panshan
 * @since jdk7
 * @version v1.0
 * */

public class SeqList<T> {
	private Object[] elements;			//数组，存储顺序表元素
	private int used;							//存储的元素个数

	//构造方法
	public SeqList(int length){
		this.elements = new Object[length];
		this.used = 0;
	}
	public SeqList(){
		this(64);
	}
	public SeqList(T[] values){
		this(values.length);
		for(int index=0; index<values.length; index++)
			this.elements[index] = values[index];
		this.used = values.length;
	}
	
	//判断是否为空
	public boolean isEmpty(){
		return this.used==0;
	}
	
	//获取顺序表中元素个数
	public int size(){
		return this.used;
	}
	
	//扩展顺序表容量
	public void reSize(){
		Object[] temp = new Object[this.used*2];
		for(int index=0; index<this.used; index++)
			temp[index] = this.elements[index];
		
		this.elements = temp;
	}
	
	//获取指定索引处元素
	public T get(int index){
		if(index>=0 && index<this.used)
			return (T)this.elements[index];
		else
			return null;
	}
	
	//设置指定索引处元素值
	public void set(int index, T value){
		if(value==null)
			throw new NullPointerException("value==null");
		else if(index<0 || index>=this.used)
			throw new IndexOutOfBoundsException(new Integer(index).toString());
		else
			this.elements[index] = value;
	}
	
	//toString()方法
	public String toString(){
		String name = this.getClass().getName();
		StringBuilder sb = new StringBuilder(name+"(");
		
		if(!isEmpty()){
			sb.append(this.elements[0].toString());
			for(int index=1; index<this.used; index++){
				sb.append(",");
				sb.append(this.elements[index].toString());
			}
		}
		
		sb.append(")");
		return sb.toString();
	}
}