package array2d;

public class Test {
	public static void main(String[] args) {
		int rows = 5;
		int cols = 3;
		int[][] values = new int[5][3];
		
		for(int row = 0; row <rows; row++)
			for(int col=0; col < cols; col++)
				values[row][col] = row+col;
		
		Matrix mt = new Matrix(rows, cols, values);
		System.out.println(mt.toString());
		
		System.out.println(mt.get(3, 2));
		System.out.println(mt.getRows());
		System.out.println(mt.getCols());
		
		mt.reSet(6, 4);
		mt.set(5, 3, 5);
		System.out.println(mt.toString());
		
		mt.reSet(2, 2);
		System.out.println(mt.toString());
	}
}
