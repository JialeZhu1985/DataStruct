package genlist;

/**
 * 广义表类
 * @author PanShan
 * */
public class GenList<T> {
	public GenNode<T> head;			//头结点
	
	//构造方法
	public GenList(){				//构造空广义表
		head = new GenNode<T>();
	}
	public GenList(T[] atoms){		//由数组构造广义表，数组元素为原子类型元素
		head = new GenNode<T>();
		for(T data:atoms)
			append(data);
	}
	
	//追加原子类型元素
	public void append(T data){
		GenNode<T> curr = head;		//获取头结点
		
		while(curr.next != null){	//将当前指针移动到链表尾部
			curr = curr.next;
		}
		
		curr.next = new GenNode<T>(data);	//在尾部追加节点
	}
	
	//在指定索引处插入原子类型元素，对索引容错
	public void insert(int index, T data){
		GenNode<T> curr = head;
		int counter = 0;
		
		if(index <0)
			throw new IllegalArgumentException(String.format("%s的值为%d", "index", index));
		else{
			while(curr.next != null && counter < index){
				curr = curr.next;
				counter++;
			}
			
			//插入
			curr.next = new GenNode<T>(data, null, curr.next);
		}
	}
	
	//指定索引处插入子广义表
	public void insert(int index, GenList<T> gl){
		GenNode<T> curr = head;
		int counter = 0;
		
		if(index < 0)
			throw new IllegalArgumentException(String.format("非法索引%s=%d", "index", index));
		else{
			while(curr.next != null && counter < index){
				curr = curr.next;
				counter++;
			}
			
			GenNode<T> node = new GenNode<T>(null, gl, curr.next);
			curr.next = node;
		}
	}
	
	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer("(");
		GenNode<T> curr = head;
		
		while(curr.next != null){			//存在后续节点
			if(curr.next.data != null){		//后续节点是普通数据节点
				sb.append(",");
				sb.append(curr.next.data.toString());
				
				curr = curr.next;			//指针节点后移
			}else if(curr.next.child != null){	//后续节点是子广义表的开头
				curr.next.child.toString();
				
				curr = curr.next;
			}else{
				;
			}
		}
		
		sb.append(")");
		
		return sb.toString();
	}
}
