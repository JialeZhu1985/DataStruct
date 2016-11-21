package sparsematrix;

/**
 * 构造带头结点的单链表类
 * 
 * @author panshan
 * @since jdk1.7
 * @version v1.0
 * */
public class SinglyList<T> extends Object {
	public Node<T> head; // 头结点的引用
	public Node<T> rear; // 尾节点的引用

	// 构造方法
	public SinglyList() {
		head = new Node<T>();
		rear = head;
	}

	public SinglyList(T[] values) {
		this();
		for (T item : values) {
			rear.next = new Node<T>(item, null);
			rear = rear.next;
		}
	}

	// 判断链表是否为空
	public boolean isEmpty() {
		return head.next == null;
	}

	// 获取指定索引的元素值
	public T get(int index) {
		Node<T> curr = head.next;
		int counter = 0;
		
		while(curr!=null && counter<index){
			curr = curr.next;
			counter++;
		}
		if(counter==index && curr!=null)
			return curr.value;
		else
			return null;
	}
	
	//设置指定索引的元素值
	public void set(int index, T value){
		Node<T> curr = head.next;
		int counter=0;
		
		while(curr!=null && counter<index){
			curr = curr.next;
			counter++;
		}
		if(counter==index && curr!=null)
			curr.value=value;
		else
			throw new UnsupportedOperationException("索引超出范围"+index);
	}
	
	//获取单链表长度
	public int size(){
		int counter=0;
		Node<T> curr = head.next;
		
		while(curr!=null){
			curr = curr.next;
			counter++;
		}
		
		return counter;
	}
	
	//在指定索引处插入元素，索引超出长度时直接插入到最后
	public void insert(int index, T value){
		Node<T> curr = this.head;
		int counter = 0;
		
		while(curr.next!=null && counter<index){
			curr = curr.next;
			counter++;
		}
		
		if(curr.next!=null)
			curr.next = new Node<T>(value, curr.next);
		else{
			curr.next = new Node<T>(value, curr.next);
			rear = curr.next;
		}
	}
	//末尾追加
	public void append(T value){
		rear.next = new Node<T>(value, null);
		rear = rear.next;
	}
	
	//删除指定索引处元素
	public T remove(int index){
		Node<T> curr = head;
		int counter = 0;
		
		while(counter<index && curr.next!=null){
			counter++;
			curr = curr.next;
		}
		
		T res = null;
		if(curr.next!=null){		//如果后继节点存在，则直接删除
			res = curr.next.value;
			if(curr.next.next!=null)		//被删除节点不是尾节点，则rear保持不变
				curr.next = curr.next.next;
			else{							//被删除节点是尾节点
				rear = curr;
				curr.next = curr.next.next;
			}
		}
		else							//如果后继节点不存在，则返回null
			res = null;
		
		return res;	
	}
	
	//清除单链表
	public void clear(){
		this.head.next = null;
	}
	
	//查找链表中的指定节点
	public Node<T> search(T key){
		Node<T> curr = head;
		Node<T> res = null;
		
		while(curr.next!=null){
			if(curr.next.value.equals(key)){
				res = curr.next;
				break;
			}else{
				curr = curr.next;
			}
		}
		
		return res;
	}
	
	//判断是否包含指定元素
	public boolean contains(T key){
		return search(key)!=null;
	}
	
//	//实现链表反转
//	public void reverse(){
//		Node<T> pre = head.next;
//		
//		if(pre.next!=null){		//判断是否只有一个数据节点
//			Node<T> curr = pre.next;
//			while(curr!=null){
//				Node<T> succ = curr.next;
//				curr.next = pre;
//				
//			}
//		}else{
//			;
//		}
//	}
	
	@Override
	public String toString() {
		Node<T> curr = head.next;
		StringBuilder sb = new StringBuilder();

		while (curr != null) {
			sb.append(curr.value.toString() + " ");
			curr = curr.next;
		}

		return sb.toString();
	}
}
