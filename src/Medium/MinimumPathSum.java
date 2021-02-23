package Medium;

/**
 * 64. Minimum Path Sum
 * 
 * Given a m x n grid filled with non-negative numbers, find a path from top
 * left to bottom right, which minimizes the sum of all numbers along its path.
 * 
 * Note: You can only move either down or right at any point in time.
 * 
 * Constraints:
 * 
 * m == grid.length
 * 
 * n == grid[i].length
 * 
 * 1 <= m, n <= 200
 * 
 * 0 <= grid[i][j] <= 100
 */
public class MinimumPathSum {
	public static void main(String[] args) {
		int[][] grid = { { 1, 3, 1 }, { 1, 5, 1 }, { 4, 2, 1 } };
		System.out.println(minPathSum(grid));
	}

	/**
	 * dp, faster than 28.02%
	 * @param grid
	 * @return
	 */
	public static int minPathSum(int[][] grid) {
		int m = grid.length;
		int n = grid[0].length;
		// 现在dp[i][j]表示到此位置的最小数值和
		int[][] dp = new int[m][n];
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (i == 0 && j == 0) {
					dp[i][j] = grid[i][j];
				} else if (i == 0 && j > 0) {
					dp[i][j] = dp[i][j - 1] + grid[i][j];
				} else if (i > 0 && j == 0) {
					dp[i][j] = dp[i - 1][j] + grid[i][j];
				} else {
					dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
				}
			}
		}

		return dp[m-1][n-1];
	}
}
