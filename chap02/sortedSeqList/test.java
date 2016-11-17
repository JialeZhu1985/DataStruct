package sortedSeqList;

public class test {
	
	public static void main(String[] args) {
		SortedSeqList<Integer>ssl = new SortedSeqList<>();
		for(int i=5; i>0; i--){
			ssl.insert(new Integer(i));
		}
		
		System.out.println(ssl.toString());
	}
}
