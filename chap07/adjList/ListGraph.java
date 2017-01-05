package adjList;

import java.util.ArrayList;

public class ListGraph<V> {
	public ArrayList<V> vertexlist = null;
	public Object[] edgeheads = null;
	
	//构造方法
	public ListGraph(int len) {
		vertexlist = new ArrayList<V>(len);
		edgeheads = new Object[len];
		
		for (int i = 0; i < len; i++) {
			edgeheads[i] = new Node<Triple>();
		}
	}
	
	public ListGraph() {
		this(10);
	}
	
	//插入顶点
	public void insertVertex(V v) {
		vertexlist.add(v);
	}
	
	//插入边
	public void insertEdge(int i, int j, int weight) {
		Triple triple = new Triple(i, j, weight);
		
		Node<Triple> curr = (Node<Triple>)edgeheads[i];
		while (curr.next != null) {
			curr = curr.next;
		}
		curr.next = new Node<Triple>(triple, null);
	}
	
	@Override
	public String toString() {
		String vertexlist = this.vertexlist.toString();
		StringBuffer sb = new StringBuffer();
		
		for (int i = 0; i < this.vertexlist.size(); i++) {
			Node<Triple> curr = ((Node<Triple>)edgeheads[i]).next;	//获取除头结点的第一个节点
			while (curr != null) {
				sb.append(curr.data.toString());
			}
			sb.append("\n");
		}
		
		return vertexlist+"\n"+sb.toString();
	}
}
