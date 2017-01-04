package tricomposed;

import array2d.Matrix;

/**
 * 三角矩阵的压缩存储
 */
public class TriMatrix {
	public TriMatrix(){
		super();
	}
	
	/**
	 * 采用一维数组进行线性压缩存储
	 * @author PanShan
	 * @param isRow:是否行主序
	 * @param isUpper:是否上三角矩阵
	 * @return res[]:一维数组
	 * */
	public static int[] LinearComposed(Matrix mt, boolean isUpper, boolean isRow) {
		//首先获取矩阵的维度，根据矩阵上/下三角元素个数，初始化一维数组
		int rows = mt.getRows();
		int cols = mt.getCols();
		if(rows != cols)
			throw new IllegalArgumentException("Matrix.rows="+rows+"Matrix.cols="+cols);
		
		int counter = (rows+1)*rows/2;
		int[] res = new int[counter];
		
		if(isUpper){	//上三角矩阵
			if(isRow){	//行主序
				for(int row = 0; row < rows; row++)
					for(int col = row; col < cols; col++){
						//矩阵中坐标为(row, col)的元素在一维数组中的索引
						int index = (rows+(rows-(row-1)))*row/2+(col-row);
						res[index] = mt.get(row, col);
					}
			}else{		//列主序
				for(int row = 0; row < rows; row++)
					for(int col = row; col < cols; col++){
						int index = (1+col)*col/2 + row;
						res[index] = mt.get(row, col);
					}
			}
		}else{			//下三角矩阵
			if(isRow){	//行主序
				for(int row = 0; row < rows; row++)
					for(int col = 0; col <= row; col++){
						int index = (1+row)*row/2+col;
						res[index] = mt.get(row, col);
					}
			}else{		//列主序
				for(int row = 0; row < rows; row++)
					for(int col = 0; col <= row; col++){
						int index = (cols + (cols - (col - 1)))*col/2 + (row-col);
						res[index] = mt.get(row, col);
					}
			}
		}
		
		return res;
	}
	
	/**
	 * 采用二维动态数组进行压缩存储
	 * @author PanShan
	 * @param isUpper:是上三角矩阵
	 * @param isRow:是行主序
	 * @return res[][]:返回压缩后的二维数组
	 * */
	public static int[][] ArrayComposed(Matrix mt, boolean isUpper, boolean isRow){
		//首先获取矩阵的行数、列数
		int rows = mt.getRows();
		int cols = mt.getCols();
		if(rows != cols)
			throw new IllegalArgumentException("mt.rows="+rows+",mt.cols="+cols);
		
		int[][] res = null;
		
		if(isUpper && isRow){			//上三角、行主序
			res = new int[rows][];
			for(int row = 0; row < rows; row++){
				res[row] = new int[cols-row];
				for(int col = 0; col < res[row].length; col++){
					res[row][col] = mt.get(row, col+row);
				}
			}
		}else if(!isUpper && isRow){	//下三角、行主序
			res = new int[rows][];
			for(int row = 0; row < rows; row++){
				res[row] = new int[row+1];
				for(int col = 0; col < res[row].length; col++){
					res[row][col] = mt.get(row, col);
				}
			}
		}else if(isUpper && !isRow){	//上三角、列主序
			res = new int[cols][];
			for(int col = 0; col < cols; col++){
				res[col] = new int[col+1];
				for(int row = 0; row < res[col].length; row++){
					res[col][row] = mt.get(row, col);
				}
			}
		}else if(!isUpper && !isRow){	//下三角、列主序
			res = new int[cols][];
			for(int col = 0; col < cols; col++){
				res[col] = new int[rows-col];
				for(int row = 0; row < res[col].length; row++){
					res[col][row] = mt.get(row+col, col);
				}
			}
		}
		return res;
	}
}
