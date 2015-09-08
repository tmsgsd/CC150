package cc150;

public class Q1_6RotateMatrix {
	public int[][] rotate(int[][] matrix) {
		int row, col;
		int length = matrix.length;
		if (length%2 == 1) {
			row = length/2;
			col = length/2 + 1;
		} else {
			row = length/2;
			col = length/2;
		}
		
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				int tmp = matrix[i][j];
				matrix[i][j] = matrix[length - 1 - j][i];
				matrix[length - 1 - j][i] = matrix[length - 1 - i][length - 1 -j];
				matrix[length - 1 - i][length - 1 -j] = matrix[j][length - 1 - i];
				matrix[j][length - 1 - i] = tmp;
			}
		}
		return matrix;
	}
	
	public static void main(String[] args) {
		Q1_6RotateMatrix test = new Q1_6RotateMatrix();
		int[][] m = new int[5][5];
		int N = 0;
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				m[i][j] = N++;
				System.out.print(m[i][j] + "\t");
			}
			System.out.println();
		}
		
		System.out.println();;
		m = test.rotate(m);
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				System.out.print(m[i][j] + "\t");
			}
			System.out.println();
		}
	}
}
