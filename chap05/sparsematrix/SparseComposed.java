package sparsematrix;

import array2d.Matrix;

/**
 * 稀疏矩阵的压缩存储方法
 * */
public class SparseComposed {
	/**
	 * 以顺序表形式存储
	 * @author PanShan
	 * @param mt:稀疏矩阵
	 * @param isRow:是行主序
	 * @return res[]:压缩后的一维数组
	 * */
	public static Triple[] seqComposed(Matrix mt, boolean isRow){
		//首先，获取矩阵的行列数
		int rows = mt.getRows();
		int cols = mt.getCols();
		
		//然后，统计矩阵非零元素个数，并创建res数组
		int counter = 0;
		for(int row = 0; row < rows; row++){
			for(int col = 0; col < cols; col++){
				if(mt.get(row, col) != 0)
					counter++;
			}
		}
		Triple[] res = new Triple[counter];
		
		//接着，依次遍历矩阵元素。若元素非零，则顺序存储在三元组中
		int index = 0;
		if(isRow){		//行主序存储
			for(int row = 0; row < rows; row++){
				for(int col = 0; col < cols; col++){
					if(mt.get(row, col) != 0){
						res[index] = new Triple(row, col, mt.get(row, col));
						index++;
					}else
						continue;
				}
			}			
		}else{			//列主序存储
			for(int col = 0; col < cols; col++){
				for(int row = 0; row < rows; row++){
					if(mt.get(row, col) != 0){
						res[index] = new Triple(row, col, mt.get(row, col));
						index++;
					}else
						continue;
				}
			}
		}
		return res;
	}
	
	/**
	 * 单链表形式压缩存储
	 * @author PanShan
	 * @param mt:稀疏矩阵
	 * @param isRow:是行主序
	 * @return SinglyList:
	 * */
	public static SinglyList<Triple> linkedComposed(Matrix mt, boolean isRow){
		//获取矩阵的行列数
		int rows = mt.getRows();
		int cols = mt.getCols();
		
		SinglyList<Triple> sl = new SinglyList<>();
		
		//依次遍历矩阵元素
		if(isRow){		//行主序
			for(int row = 0; row < rows; row++){
				for(int col = 0; col < cols; col++){
					if(mt.get(row, col) != 0){
						sl.append(new Triple(row, col, mt.get(row, col)));
					}else
						continue;
				}
			}
		}else{			//列主序
			for(int col = 0; col < cols; col++){
				for(int row = 0; row < rows; row++){
					if(mt.get(row, col) != 0){
						sl.append(new Triple(row, col, mt.get(row, col)));
					}else
						continue;
				}
			}
		}
		return sl;
	}
	
	/**
	 * 行单链表压缩存储稀疏矩阵
	 * @author PanShan
	 * @param mt:稀疏矩阵
	 * @return SinglyList[] res:单链表数组
	 * */
	public static Object[] rowLinkedComposed(Matrix mt){
		//获取矩阵的行列数
		int rows = mt.getRows();
		int cols = mt.getCols();
		
//		SinglyList<Triple>[] res = new SinglyList<Triple>[rows];	//不能直接创建泛型数组
		
		Object[] res = new Object[rows];
		
		for(int row = 0; row < rows; row++){
			SinglyList<Triple> sl = new SinglyList<Triple>();
			for(int col = 0; col < cols; col++){
				if(mt.get(row, col) != 0){
					sl.append(new Triple(row, col, mt.get(row, col)));
				}else
					continue;
			}
			res[row] = sl;
		}

		return res;
	}
}
