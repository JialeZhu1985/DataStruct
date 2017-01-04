package linkedqueue;

public class Test {
	public static void main(String[] args) {
		LinkedQueue<Integer> lq = new LinkedQueue<>();
		
		System.out.println(lq.isEmpty());
		
		for(int i=0; i<5; i++)
			lq.enQueue(i);
		
		System.out.println(lq.toString());
		
		lq.enQueue(5);
		System.out.println(lq.peek().toString());
		System.out.println(lq.deQueue().toString());
		
		System.out.println(lq.deQueue().toString());
		System.out.println(lq.deQueue().toString());
		System.out.println(lq.deQueue().toString());
		System.out.println(lq.deQueue().toString());
		System.out.println(lq.deQueue().toString());
		System.out.println(lq.deQueue().toString());
	}
}
