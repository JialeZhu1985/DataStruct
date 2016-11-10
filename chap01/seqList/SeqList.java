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
	
	//在指定位置插入元素
	public void insert(int index, T value){
		//输入参数检查
		if(value==null)
			throw new NullPointerException("value==null");
		else if(index<0)
			index = 0;
		else if(index>this.used)
			index = this.used;
		else
			;
		
		//顺序表容量检查
		if(this.used==this.elements.length)
			reSize();
		
		//插入元素
		for(int i=this.used; i>index; i--){
			this.elements[i] = this.elements[i-1];
		}
		this.elements[index] = value;
		this.used++;
	}
	
	//在末尾插入
	public void insert(T value){
		insert(this.used, value);
	}
	
	//删除指定索引元素
	public T remove(int index){
		//索引检查
		if(index<0 || index>=this.used)
			throw new IndexOutOfBoundsException("索引越界");
		else{
			T res = (T)this.elements[index];
			
			for(int i=index; i<this.used; i++){
				this.elements[i] = this.elements[i+1];
			}
			this.elements[this.used--] = null;		//释放元素，并改变元素数目
			
			return res;
		}
	}
	
	//删除所有元素
	public void clear(){
		this.used = 0;
	}
}