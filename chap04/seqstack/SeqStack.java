package seqstack;

/**
 * 顺序栈，使用数组进行存储
 * */
public class SeqStack<T> {
	private Object[] elements;
	private int used ;
	
	//构造方法
	public SeqStack(int capacity){
		elements = new Object[capacity];
		this.used = 0;
	}
	public SeqStack(){
		this(16);
	}
	public SeqStack(T[] elements){
		this(elements.length);
		for(int index=0; index<elements.length; index++)
			this.elements[index] = elements[index];
		this.used += elements.length;
	}
	
	//扩展容量
	public void increCapacity(){
		Object[] tmp = new Object[this.elements.length*2];
		for(int index=0; index<this.used; index++){
			tmp[index] = this.elements[index];
		}
		this.elements = tmp;
	}
	
	//获取容量
	public int getCapacity(){
		return this.elements.length;
	}
	
	//入栈
	public void push(T value){
		if(value==null)		//空元素检查
			throw new NullPointerException("value==null");
		
		if(this.used==this.elements.length)	//栈满检查
			increCapacity();
		
		this.elements[this.used++] = value;	//追加元素，并改变this.used值
	}
	
	//出栈
	public T pop(){
		T tmp = (T)(this.elements[this.used-1]);
		this.used--;
		return tmp;
	}
	
	//返回栈顶元素
	public T peek(){
		return (T)(this.elements[this.used-1]);
	}
	
	//判断栈空
	public boolean isEmpty(){
		return this.used==0;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for(int index=this.used-1; index>0; index--)
			sb.append(this.elements[index]+" ");
		sb.append(this.elements[0]);
		
		return sb.toString();
	}
}
