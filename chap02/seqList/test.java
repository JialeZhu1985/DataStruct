package seqList;

public class test {
	public static void main(String[] args) {
		String[] strs = {"aa", "bb", "cc", "dd"};
		SeqList<String> seqList = new SeqList<>(strs);
		
		String[] strs2 = {"aa", "bb", "cc", "dd"};
		SeqList<String> seqList2 = new SeqList<>(strs2);
		
		System.out.println(seqList.equals(seqList2));
	}
}
