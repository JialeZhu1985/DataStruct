package polyNomial;

/**
 * 一元多项式排序单链表
 * */
public class PolySinglyList<T extends Comparable<T>&Addible<T>> {
	Node<T> head = null;
	
	//构造方法
	public PolySinglyList() {
		head = new Node<T>();
	}
	
	public PolySinglyList(T[] terms) {
		this();
		for(T term:terms){
			insert(term);
		}
	}
	
	//插入节点
	public void insert(T term){
		Node<T> curr = head;
		while(curr.next!=null && curr.next.value.compareTo(term)<0){
			curr = curr.next;
		}
		
		curr.next = new Node<T>(term, curr.next);
	}
	
	//删除当前节点的下一个节点
	public void remove(Node<T> node){
		if(node.next!=null)
			node.next = node.next.next;
	}
	
	//遍历多项式链表，删除冗余项
	public void simplify(){
		Node<T> curr = head;
		while(curr.next!=null){
			if(curr.next.value.removiable()){
				curr.next = curr.next.next;
			}else{
				curr = curr.next;				
			}
		}
	}
	
	//多项式链表相加
	public PolySinglyList<T> add(PolySinglyList<T> otherpls){
		PolySinglyList<T> pls = new PolySinglyList<>();
		PolySinglyList<T> pls1 = this;
		PolySinglyList<T> pls2 = otherpls;
		
		Node<T> curr = pls.head;
		Node<T> curr1 = pls1.head;
		Node<T> curr2 = pls2.head;
		
		while(curr1.next!=null && curr2.next!=null){
			if(curr1.next.value.compareTo(curr2.next.value)<0){
				curr.next = new Node<T>(curr1.next.value, null);		//深拷贝
				curr = curr.next;
				curr1 = curr1.next;
			}else if(curr1.next.value.compareTo(curr2.next.value)>0){
				curr.next = new Node<T>(curr2.next.value, null);		//深拷贝
				curr = curr.next;
				curr2 = curr2.next;
			}else{
				T t = curr1.next.value.add(curr2.next.value);
				curr.next = new Node<T>(t, null);
				curr = curr.next;
				curr1 = curr1.next;
				curr2 = curr2.next;
			}
		}
		
		while(curr1.next!=null || curr2.next!=null){		//有一个链表未遍历完
			if(curr1.next!=null){		//链表1次数比较低
				Node<T> node = new Node<>(curr1.next.value, null);		//深拷贝
				curr.next = node;
			}else{
				Node<T> node = new Node<>(curr2.next.value, null);		//深拷贝
				curr.next = node;
			}
		}
		
		return pls;
	}
	
	@Override
	public String toString() {
		Node<T> curr = head;
		
		StringBuilder sb = new StringBuilder();
		while(curr.next!=null){
			sb.append(curr.next.value.toString());
			curr = curr.next;
		}
		
		return sb.toString();
	}
}