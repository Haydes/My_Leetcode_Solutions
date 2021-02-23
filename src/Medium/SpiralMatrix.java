package Medium;

import java.util.ArrayList;
import java.util.List;

/**
 * 54. Spiral Matrix
 * 
 * Given an m x n matrix, return all elements of the matrix in spiral order.
 *
 * Constraints:
 * 
 * m == matrix.length
 * 
 * n == matrix[i].length
 * 
 * 1 <= m, n <= 10
 * 
 * -100 <= matrix[i][j]<= 100
 */
public class SpiralMatrix {
	public static void main(String[] args) {
		int[][] matrix = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
		System.out.println(spiralOrder(matrix));
	}

	/**
	 * faster than 100%
	 * 
	 * @param matrix
	 * @return
	 */
	public static List<Integer> spiralOrder(int[][] matrix) {
		List<Integer> result = new ArrayList<Integer>();
		int m = matrix.length;
		int n = matrix[0].length;
		int direction = 0; // 0 - right 1 - down 2 - left 3 - top

		boolean[][] visited = new boolean[m][n];
		int i = 0; // 第几个数字
		int x = 0, y = 0;
		while (i < m * n) {
			i++;
			result.add(matrix[x][y]);
			visited[x][y] = true;
			if (direction == 0) {
				if (y + 1 < n && !visited[x][y + 1]) {
					y += 1;
				} else {
					direction = 1;
					x += 1;
				}
			} else if (direction == 1) {
				if (x + 1 < m && !visited[x + 1][y]) {
					x += 1;
				} else {
					direction = 2;
					y -= 1;
				}
			} else if (direction == 2) {
				if (y - 1 >= 0 && !visited[x][y - 1]) {
					y -= 1;
				} else {
					direction = 3;
					x -= 1;
				}
			} else {
				if (x - 1 >= 0 && !visited[x - 1][y]) {
					x -= 1;
				} else {
					direction = 0;
					y += 1;
				}
			}
		}
		return result;
	}
}
