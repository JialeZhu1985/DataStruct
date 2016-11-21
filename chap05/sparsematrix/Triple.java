package sparsematrix;

import java.util.Collections;

/**
 * 存储矩阵元素的三元组(row, col, value)
 */
public class Triple implements Comparable<Triple> {
	private int row, col, value;

	// 构造方法
	public Triple(int row, int col, int value) {
//		super();
		if (row < 0 || col < 0)
			throw new IllegalArgumentException("row=" + row + ",col=" + col);

		this.row = row;
		this.col = col;
		this.value = value;
	}

	// 获取行列序号、元素值
	public int getRow() {
		return this.row;
	}

	public int getCol() {
		return this.col;
	}

	public int getValue() {
		return this.value;
	}

	/**
	 * 按行列序号比较元素，行主序
	 */
	@Override
	public int compareTo(Triple o) {
		int res;
		if (this.getRow() == o.getRow() && this.getCol() == o.getCol())
			res = 0;
		else if (this.getRow() < o.getRow() || this.getRow() == o.getRow() && this.getCol() < o.getCol())
			res = 1;
		else
			res = -1;

		return res;
	}

	/**
	 * 比较三元组的行列序号、值是否相同，与compareTo()方法不同
	 */
	@Override
	public boolean equals(Object obj) {
		Triple o = (Triple) obj;
		return this.getRow() == o.getRow() && this.getCol() == o.getCol() && this.getValue() == o.getValue();
	}
	
	/**
	 * 通过交换行列号，使矩阵转置
	 * */
	public void toTranspose(){
		this.row = (this.col + this.row) - (this.col = this.row);
	}
	
	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append("("+this.getRow()+","+this.getCol()+","+this.getValue()+")");
		return sb.toString();
	}
}
