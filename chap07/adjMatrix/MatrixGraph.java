package adjMatrix;

import java.util.ArrayList;

public class MatrixGraph<T> {
	public int MAX_WEIGHT = -1;		//表示最大权值
	public ArrayList<T> vertexlist = null;			//存储顶点集合
	public int[][] edges = null;					//存储边的集合
	
	//构造方法
	public MatrixGraph(int len) {		//参数len指定顶点集合初始容量、边集合初始容量
		vertexlist = new ArrayList<>(len);
		edges = new int[len][len];
		
		//初始化边权值为无穷大
		for (int i = 0; i < len; i++)
			for (int j = 0; j < len; j++) {
				if (i == j)
					edges[i][j] = 0;
				else
					edges[i][j] = MAX_WEIGHT;
			}
		
	}
	
	public MatrixGraph() {
		this(10);
	}
	
	/**
	 * 插入顶点
	 * @param T : 顶点元素
	 * @return int : 插入顶点的索引
	 * */
	public int insertVertex(T v) {
		vertexlist.add(v);
		return vertexlist.size() - 1;
	}
	
	/**
	 * 插入边
	 * @param i : 起点
	 * @param j : 终点
	 * @param weight : 权值
	 * */
	public void insertEdge(int i, int j, int weight) {
		if (i != j) {	//不能形成环
			edges[i][j] = weight;
		}
	}
	
	//删除边
	public void removeEdge(int i, int j) {
		if (i != j)
			edges[i][j] = MAX_WEIGHT;
	}
	
	//删除顶点
	public void removeVertex(int i) {
		//获取当前顶点个数
		int size = vertexlist.size();
		
		//移除顶点
		vertexlist.remove(i);
		
		//移除边
		for (int row = 0; row < size; row++) {
			for (int col = i; col < size - 1; col++) {
				edges[row][col] = edges[row][col+1];
			}
			edges[row][size-1] = MAX_WEIGHT;
		}
		for (int col = 0; col < size; col++) {
			for (int row = i; row < size - 1; row++) {
				edges[row][col] = edges[row+1][col];
			}
			edges[col][size-1] = MAX_WEIGHT;
		}
	}

	//获得边的权值
	public int weight(int i, int j) {
		return edges[i][j];
	}
	
	//返回顶点vj之后属于vi的邻接顶点的顶点。
	public int next(int i, int j) {
		int size = vertexlist.size();
		
		if (0 <= i && i < size && -1 <= j && j < size - 1 && i != j) {
			for (int k = j + 1; k < size; k++) {
				if (0 < edges[i][k]) {	//边存在
					return k;
				}
			}
		}
		
		return -1;
	}
	
	//输出图
	@Override
	public String toString() {
		String vertexlist = this.vertexlist.toString();
		
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < this.vertexlist.size(); i++) {
			sb.append("\n");
			for (int j = 0; j < this.vertexlist.size(); j++) {
//				sb.append("("+i+","+j+","+edges[i][j]+")");
				sb.append(edges[i][j]+",");
			}
		}
		
		return vertexlist+"\n"+sb.toString();
		
	}
}
