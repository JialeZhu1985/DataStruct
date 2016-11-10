package seqList;

public class test {
	public static void main(String[] args) {
		String[] strs = {"aa", "bb", "cc", "dd"};
		SeqList<String> seqList = new SeqList<>(strs);
		
		System.out.println(seqList.toString());
		
		seqList.set(2, "ee");
		
		System.out.println(seqList.get(2));
		System.out.println(seqList.toString());
		
		seqList.insert(1, "ff");
		System.out.println(seqList.toString());
		seqList.insert(-1, "gg");
		seqList.insert(seqList.size(), "hh");
		System.out.println(seqList.toString());
		
		System.out.println(seqList.remove(2));

		System.out.println(seqList.toString());
	}
}
