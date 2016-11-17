package linkedList.sortedSinglyList;

/**
 * 排序单链表类的实现
 * @author panshan
 * @since jdk1.7
 * @version v1.0
 * */
public class SortedSinglyList<T extends Comparable<? super T>> {
	public Node<T> head = null;
	
	//构造方法
	public SortedSinglyList() {
		head = new Node();
	}
	public SortedSinglyList(T[] values){
		this();
		for(T value:values)
			this.insert(value);
	}
	public SortedSinglyList(SortedSinglyList ssl){
		this();
		Node<T> curr = ssl.head;
		while(curr.next!=null){
			this.insert(curr.next.value);
			curr = curr.next;
		}
	}
	
	//插入数据节点
	public void insert(T value){
		Node<T> curr = head;
		
		while(curr.next!=null && curr.next.value.compareTo(value)<0){
			curr = curr.next;
		}
		curr.next = new Node(value, curr.next);	
	}
	
	//查找
	public Node<T> search(T key){
		Node<T> curr = head;
		
		while(curr.next!=null && curr.next.value.compareTo(key)<0){
			curr = curr.next;
		}
		if(curr.next!=null && curr.next.value.equals(key))
			return curr.next;
		else
			return null;
	}
	
	//删除操作
	public T remove(T key){
		Node<T> curr = head;
		
		while(curr.next!=null && !curr.next.value.equals(key)){
			curr = curr.next;
		}
		
		if(curr.next!=null && curr.next.value.equals(key)){
			curr.next = curr.next.next;
			return key;
		}else{
			return null;
		}
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		Node<T> curr = head;
		while(curr.next!=null){
			sb.append(curr.next.value.toString()+" ");
			curr = curr.next;
		}
		return sb.toString();
	}
}
