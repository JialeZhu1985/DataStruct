package linkedList.singlyList;

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
	
//	//在指定索引处插入元素
//	public void insert(int index, T value){
//		Node<T> curr = head.next;
//		int counter = 0;
//		
//		while(curr!=null && counter<index){
//			curr = curr.next;
//			counter++;
//		}
//		if(counter==index && curr!=null)
//			curr = new Node<T>(value, curr.next);
//		else if(counter==index && curr==null)
//			curr = new Node<T>(value, null);
//		else
//			throw new UnsupportedOperationException("索引越界");
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
