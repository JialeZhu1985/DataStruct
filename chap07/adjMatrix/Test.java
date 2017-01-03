package adjMatrix;

public class Test {
	public static void main(String[] args) {
		MatrixGraph<String> mg = new MatrixGraph<>(10);
		
		//插入顶点
		for (int i = 0; i < 5; i++) {
			char tmp = (char) ((int)'a'+i);
			mg.insertVertex(Character.toString(tmp));
		}
		
		//插入边
		mg.insertEdge(0, 2, 3);
		mg.insertEdge(0, 4, 4);
		mg.insertEdge(1, 3, 4);
		mg.insertEdge(4, 2, 6);
		mg.insertEdge(3, 2, 5);
		
		System.out.println(mg.toString());
		
		//移除第三个顶点
		mg.removeVertex(3);
		System.out.println(mg.toString());
	}
}
