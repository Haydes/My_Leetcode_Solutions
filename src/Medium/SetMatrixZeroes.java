package Medium;

import utils.MyPrinter;

/**
 * 73. Set Matrix Zeroes
 * 
 * Given an m x n matrix. If an element is 0, set its entire row and column to
 * 0. Do it in-place.
 * 
 * Follow up:
 * 
 * A straight forward solution using O(mn) space is probably a bad idea. A
 * simple improvement uses O(m + n) space, but still not the best solution.
 * Could you devise a constant space solution?
 *
 */
public class SetMatrixZeroes {
	public static void main(String[] args) {
		int[][] matrix = { { 0, 1, 2, 0 }, { 3, 4, 5, 2 }, { 1, 3, 1, 5 } };
		MyPrinter.printMatrix(matrix);
		setZeroes(matrix);
		System.out.println("--------------");
		MyPrinter.printMatrix(matrix);
	}

	/**
	 * 40.2 MB, less than 93.75%
	 */
	public static void setZeroes(int[][] matrix) {
		int m = matrix.length;
		int n = matrix[0].length;
		// 标记第一行是否需要变为0
		boolean firstRow = false;
		// 标记第一列是否需要变为0
		boolean firstCol = false;
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (matrix[i][j] == 0) {
					if (i == 0) {
						firstRow = true;
					}
					if (j == 0) {
						firstCol = true;
					}
					matrix[i][0] = 0;
					matrix[0][j] = 0;
				}
			}
		}

		for (int i = 1; i < m; i++) {
			for (int j = 1; j < n; j++) {
				if (matrix[i][0] == 0 || matrix[0][j] == 0) {
					matrix[i][j] = 0;
				}
			}
		}
		if (firstRow) {
			for (int i = 0; i < n; i++) {
				matrix[0][i] = 0;
			}
		}
		if (firstCol) {
			for (int i = 0; i < m; i++) {
				matrix[i][0] = 0;
			}
		}
	}
}
