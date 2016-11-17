package seqList;

/**
 * 约瑟夫环问题
 * @author panshan
 * @since jdk1.7
 * @version v1.0
 * */
public class Josephus {
	public Josephus(int number, int start, int step){
		//创建顺序表
		SeqList<Character> seqlist = new SeqList<Character>(number);
		for(int i=0; i<number; i++)
			seqlist.insert((char)('A'+i));
		System.out.println(seqlist.toString());
		
		int index = start;
		while(seqlist.size()>1){
			index = (index+step-1)%seqlist.size();
			System.out.print(seqlist.remove(index));
			System.out.println(seqlist.toString());
		}
	}
	
	public static void main(String[] args) {
		new Josephus(6, 0, 3);
	}
}
