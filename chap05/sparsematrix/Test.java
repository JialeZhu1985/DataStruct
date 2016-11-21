package sparsematrix;

import array2d.Matrix;
import java.util.Random;

public class Test {
	public static void main(String[] args) {
		int rows = 10, cols = 15;
		int[][] values = new int[rows][cols];
		
		Matrix mt = new Matrix(rows, cols, values);
		System.out.println(mt.toString());
		
		//初始化稀疏矩阵
		Random r = new Random();
		for(int i = 0; i< 20; i++){
			mt.set(r.nextInt(10), r.nextInt(15), r.nextInt(99));
		}
		System.out.println(mt.toString());
		System.out.println("---------------");
		
//		//行主序压缩存储
//		Triple[] res = SparseComposed.seqComposed(mt, true);
//		for(Triple item:res)
//			System.out.println(item.toString());
//		
//		System.out.println("----------------");
//		//列主序压缩存储
//		Triple[] res2 = SparseComposed.seqComposed(mt, false);
//		for(Triple item:res2)
//			System.out.println(item.toString());
//		
		//链式压缩存储，行主序
		SinglyList<Triple> sl = SparseComposed.linkedComposed(mt, true);
		System.out.println(sl.toString());
		
		//链式压缩存储、列主序
		SinglyList<Triple> sl2 = SparseComposed.linkedComposed(mt, false);
		System.out.println(sl2.toString());
	}
}
