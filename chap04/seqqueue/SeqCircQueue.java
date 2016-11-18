package seqqueue;

/**
 * 基于顺序表的循环队列
 * */
public class SeqCircQueue<T> {
	private Object[] elements = null;
	private int front = 0, rear = 0;

	// 构造方法
	public SeqCircQueue(int capacity) {
		this.elements = new Object[capacity];
		this.front = this.rear = 0;
	}

	public SeqCircQueue() {
		this(8);
	}

	// 判断队列是否为空
	public boolean isEmpty() {
		return front == rear;
	}

	// 判断队列是否满
	public boolean isFull() {
		return front == (rear + 1) % elements.length;
	}

	// 扩容
	public void increCapacity() {
		Object[] tmp = new Object[this.elements.length * 2];
		int j=0;
		for (int i = front; i != rear; i = (i + 1) % this.elements.length) {
			tmp[j++] = this.elements[i];
		}
		this.front = 0;
		this.rear = j;
		this.elements = tmp;
	}

	// 入队
	public void enQueue(T value) {
		// 空对象检查
		if (value == null)
			throw new NullPointerException("value==null");
		//队列满检查
		if(isFull()){
			increCapacity();
		}
		//加入对象
		this.elements[rear] = value;
		rear = (rear+1)%this.elements.length;
	}
	
	//出队
	public T deQueue(){
		if(isEmpty())
			return null;
		else{
			T res = (T)this.elements[front];
			front = (front+1)%this.elements.length;
			return res;
		}
	}
	
	//获取队头元素
	public T peek(){
		return isEmpty() ? null:(T)this.elements[front];
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for(int index=front; index!=rear; index=(index+1)%this.elements.length)
			sb.append(this.elements[index].toString()+" ");
		
		return sb.toString();
	}
	
	//获取容量
	public int getCapacity(){
		return this.elements.length;
	}
}
