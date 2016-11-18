package seqqueue;

public class Test {
	public static void main(String[] args) {
		SeqCircQueue<Integer> scq = new SeqCircQueue<>(5);
		
		for(int i=0; i<4; i++){
			scq.enQueue(i);
		}
		System.out.println(scq.isFull());
		
		//查看队列及其容量
		System.out.println(scq.toString());
		System.out.println(scq.getCapacity());
		System.out.println("-----------------");
		
		//入队
		scq.enQueue(4);
		System.out.println(scq.toString());
		System.out.println(scq.getCapacity());
		System.out.println("----------------");
		
		//出队
		System.out.println(scq.deQueue().toString());
		System.out.println(scq.deQueue().toString());
		System.out.println(scq.deQueue().toString());
		System.out.println(scq.deQueue().toString());
		System.out.println("------------------------");
		
		//获取队头元素
		System.out.println(scq.peek().toString());
		System.out.println("-------------------------");
		
		System.out.println(scq.isEmpty());
		System.out.println(scq.deQueue());
		System.out.println(scq.isEmpty());
		
	}
}
