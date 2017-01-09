package linklist;

public class LinkReverse {
	//链表反转
	public static void reverseList(Linked link) {
		Node head = null, pre = null, curr = null, succ = null;
		
		head = link.head;	//获取头结点
		
//		//如果是空链表或只有一个数据节点的链表，则直接结束
//		if (head.next == null || head.next.next == null)
//			return;
//		
//		//链表长度大于1时，先初始化pre指针和curr指针
//		pre = head.next;
//		curr = pre.next;
//		pre.next = null;
//		
//		while (curr != null) {
//			succ = curr.next;
//			curr.next = pre;
//			
//			pre = curr;
//			curr = succ;
//		}
//		
//		head.next = pre;
		
		if (head.next == null) {	//如果是空链表，直接结束
			return;
		}
		
		head = link.head;	//获取头结点
		
		pre = head.next;
		curr = pre.next;
		
		pre.next = null;	//第一个节点变为最后一个节点，无后继
		
		while (curr != null) {
			succ = curr.next;	//保存当前节点的后继节点
			curr.next = pre;	//更改当前节点的后继节点
			
			//指针依次后移
			pre = curr;
			curr = succ;
		}
		head.next = pre;
	}
	
	public static void main(String[] args) {
		Linked link = new Linked();
		for (int i = 0; i < 10; i++)
			link.append(i);
		System.out.println(link.toString());
		
		reverseList(link);
		System.out.println(link.toString());
	}
}
