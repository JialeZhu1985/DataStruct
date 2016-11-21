package array2d;

/**
 * 基于二维数组的矩阵类
 * */
public class Matrix {
	private int rows, cols; // 矩阵的行列数
	private int[][] elements; // 二维数组

	// 构造方法
	public Matrix(int rows, int cols) {
		this.rows = rows;
		this.cols = cols;
		this.elements = new int[this.rows][this.cols];
	}

	public Matrix(int rows, int cols, int[][] values) {
		this(rows, cols);

		// 根据二维数组values构造矩阵，values维度不足时补0，维度超出时忽略
		for (int row = 0; row < this.rows && row < values.length; row++) {
			for (int col = 0; col < this.cols && col < values[row].length; col++) {
				this.elements[row][col] = values[row][col];
			}
		}
		
	}
	
	//返回矩阵行列数
	public int getRows(){
		return this.rows;
	}
	
	public int getCols(){
		return this.cols;
	}
	
	//返回指定元素、设置指定元素值(对索引容错)
	public int get(int row, int col){
		if(0 <= row && row < this.rows && 0<= col && col < this.cols)
			return this.elements[row][col];
		else
			throw new IndexOutOfBoundsException("row="+row+",col="+col);
	}
	
	public void set(int row, int col, int value){
		if(0 <= row && row < this.rows && 0<= col && col < this.cols)
			this.elements[row][col] = value;
		else
			throw new IndexOutOfBoundsException("row="+row+",col="+col);
	}
	
	//重置矩阵行列值：若参数指定的行列大于当前行列，则扩容；若小于当前行列，则丢弃多余元素
	public void reSet(int rows, int cols){
		if(rows <0 || cols < 0)
			throw new IllegalArgumentException("rows="+rows+",cols"+cols);
		else{
			int[][] tmp = new int[rows][cols];
			for(int row = 0; row < rows && row < this.rows; row++)
				for(int col = 0; col < cols && col <this.cols; col++)
					tmp[row][col] = this.elements[row][col];
		}
		
	}
}
