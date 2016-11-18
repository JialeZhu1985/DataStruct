package priorityqueue;

import java.util.Random;

public class Test {
	public static void main(String[] args) {
		PriorityQueue<Integer> pq = new PriorityQueue<>(true);
		System.out.println(pq.isEmpty());
		
		Random r = new Random();
		for(int i=0; i<5; i++)
			pq.enQueue(r.nextInt(20));
		System.out.println(pq.toString());
		System.out.println("---------------------");
		
		pq.enQueue(r.nextInt(20));
		System.out.println(pq.peek().toString());
		System.out.println(pq.toString());
		System.out.println(pq.deQueue().toString());
		
		Integer[] integers = new Integer[10];
		for(int i=0; i<10; i++){
			integers[i] = r.nextInt(20);
		}
		PriorityQueue<Integer> pq2 = new PriorityQueue<>(integers, false);
		System.out.println(pq2.toString());
	}
}
