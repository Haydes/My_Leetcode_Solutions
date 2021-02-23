package Medium;

/**
 * 59. Spiral Matrix II
 * 
 * Given a positive integer n, generate an n x n matrix filled with elements
 * from 1 to n2 in spiral order.
 *
 */
public class SpiralMatrixII {
	public static void main(String[] args) {
		int[][] generateMatrix = generateMatrix(4);
		for (int[] is : generateMatrix) {
			System.out.print("[");
			for (int i : is) {
				System.out.print(" "+i+" ");
			}
			System.out.println("]");
		}
	}

	/**
	 * faster than 100%
	 * @param n
	 * @return
	 */
	public static int[][] generateMatrix(int n) {
		int size = n * n;
		int[][] matrix = new int[n][n];
		boolean[][] visited = new boolean[n][n];

		int direction = 0; // 0-right 1-down 2-left 3-up
		int x = 0, y = 0;

		for (int i = 1; i <= size; i++) {
			matrix[x][y] = i;
			visited[x][y] = true;
			if (direction == 0) { // 往右
				if (y + 1 < n && !visited[x][y + 1]) {
					y += 1;
				} else {
					direction = 1;
					x += 1;
				}
			} else if (direction == 1) { // 往下
				if (x + 1 < n && !visited[x + 1][y]) {
					x += 1;
				} else {
					direction = 2;
					y -= 1;
				}
			} else if (direction == 2) { // 往左
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

		return matrix;
	}
}
