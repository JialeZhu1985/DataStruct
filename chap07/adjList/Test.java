package adjList;

public class Test {
	public static void main(String[] args) {
		ListGraph<Character> lg = new ListGraph<>(10);
		
		//添加顶点
		for (int i = 0; i < 6; i++) {
			lg.insertVertex((char)((int)'a'+i));
		}
		
//		lg.insertEdge(0, 1, 2);
//		lg.insertEdge(3, 5, 3);
		
		System.out.println(lg.toString());
	}
}
