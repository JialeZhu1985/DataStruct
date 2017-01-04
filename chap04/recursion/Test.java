package recursion;
import java.util.Random;

public class Test {
	public static void main(String[] args) {
		Random r = new Random();
		Integer[] values = new Integer[3];
		
		for(int i=0; i<3; i++){
			values[i] = r.nextInt(20);
		}
		
		SinglyList<Integer> sl = new SinglyList<>(values);
		
		System.out.println(sl.toString());
	}
}
