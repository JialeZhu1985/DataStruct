package tricomposed;

import array2d.Matrix;

public class Test {
	
	public static void main(String[] args) {
		//创建Matrix对象，并初始化
		Matrix mt = new Matrix(5,5);
		int i = 10;
		for(int row = 0; row < 5; row++)
			for(int col = 0; col < 5; col++, i++){
				mt.set(row, col, i);
			}
		
		System.out.println(mt.toString());
		
		//将三角矩阵进行线性压缩存储，返回压缩后的一维数组
		int[] res;

		res = TriMatrix.LinearComposed(mt, true, true);		//上三角、行主序
		StringBuffer sb1 = new StringBuffer();
		for(int item:res){
			sb1.append(item+" ");
		}
		System.out.println(sb1.toString());
		
		res = TriMatrix.LinearComposed(mt, true, false);	//上三角、列主序
		StringBuffer sb2 = new StringBuffer();
		for(int item:res){
			sb2.append(item+" ");
		}
		System.out.println(sb2.toString());

		res = TriMatrix.LinearComposed(mt, false, true);	//下三角、行主序
		StringBuffer sb3 = new StringBuffer();
		for(int item:res){
			sb3.append(item+" ");
		}
		System.out.println(sb3.toString());
		
		res = TriMatrix.LinearComposed(mt, false, false);		//下三角、列主序
		StringBuffer sb4 = new StringBuffer();
		for(int item:res){
			sb4.append(item+" ");
		}
		System.out.println(sb4.toString());
		
		System.out.println("-----------------");
		
		//将三角矩阵进行二维动态数组压缩存储，返回压缩后的二维数组
		int[][] result;
		result = TriMatrix.ArrayComposed(mt, true, true);	//上三角、行主序
		StringBuffer sbb1 = new StringBuffer();
		for(int row = 0; row < result.length; row++){
			for(int col = 0; col < result[row].length; col++){
				sbb1.append(result[row][col]+" ");
			}
			sbb1.append("\n");
		}
		System.out.println(sbb1.toString());
		
		result = TriMatrix.ArrayComposed(mt, true, false);	//上三角、列主序
		StringBuffer sbb2 = new StringBuffer();
		for(int col = 0; col < result.length; col++){
			for(int row = 0; row < result[col].length; row++){
				sbb2.append(result[col][row]+" ");
			}
			sbb2.append("\n");
		}
		System.out.println(sbb2.toString());
		
		result = TriMatrix.ArrayComposed(mt, false, true);	//下三角、行主序
		StringBuffer sbb3 = new StringBuffer();
		for(int row = 0; row < result.length; row++){
			for(int col = 0; col < result[row].length; col++){
				sbb3.append(result[row][col]+" ");
			}
			sbb3.append("\n");
		}
		System.out.println(sbb3.toString());
		
		result = TriMatrix.ArrayComposed(mt, false, false);	//下三角、列主序
		StringBuffer sbb4 = new StringBuffer();
		for(int col = 0; col < result.length; col++){
			for(int row = 0; row < result[col].length; row++){
				sbb4.append(result[col][row]+" ");
			}
			sbb4.append("\n");
		}
		System.out.println(sbb4.toString());
	}
}