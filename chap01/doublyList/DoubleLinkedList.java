package doublyList;

public class DoubleLinkedList<T> {
	public DoubleNode<T> head, tail;
	
	//构造方法
	public DoubleLinkedList() {
		head = new DoubleNode<T>();
		tail = new DoubleNode<T>();
		head.next = tail;
		tail.pre = head;
	}
	public DoubleLinkedList(T[] values){
		this();

		for(T value:values){
			DoubleNode<T> node = new DoubleNode<T>(value, tail.pre, tail);
			tail.pre.next = node;
			tail.pre = node;
		}
	}
	
	//指定索引index处插入,index<0时插在最前面，index超出链表末尾时插在最后面
	public void insert(int index, T value){
		DoubleNode<T> curr = head;
		int counter = 0;
		
		while(counter<index && curr.next!=tail){
			counter++;
			curr = curr.next;
		}
		
		DoubleNode<T> node = new DoubleNode<T>(value, curr, curr.next);
		curr.next.pre = node;
		curr.next = node;
	}
	
	//删除指定索引处的节点，索引超出范围返回null
	public T remove(int index){
		DoubleNode<T> curr = head;
		int counter = 0;
		
		while(counter<index && curr.next!=tail){
			curr = curr.next;
			counter++;
		}
		
		if(counter==index && curr.next!=tail){
			T res = curr.next.value;
			curr.next.next.pre = curr;
			curr.next = curr.next.next;
			return res;
		}else{
			return null;
		}
	}
				
	@Override
	public String toString() {
		DoubleNode<T> curr = head;
		StringBuilder sb = new StringBuilder();
		
		while(curr.next!=tail){
			sb.append(curr.next.value.toString()+" ");
			curr = curr.next;
		}
		
		return sb.toString();
	}
	
	//反序输出
	public String revString(){
		DoubleNode<T> curr = tail;
		StringBuilder sb = new StringBuilder();
		
		while(curr.pre!=head){
			sb.append(curr.pre.value.toString()+" ");
			curr = curr.pre;
		}
		
		return sb.toString();
	}

}
