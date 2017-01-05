package adjList;

//存储节点的三元组
public class Triple {
	public int row, col, weight;
	
	public Triple(int row, int col, int weight) {
		this.row = row;
		this.col = col;
		this.weight = weight;
	}
	
	@Override
	public String toString() {
		return "("+row+","+col+","+weight+")";
	}
}
