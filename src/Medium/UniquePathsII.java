package Medium;

/**
 * 63. Unique Paths II
 * 
 * A robot is located at the top-left corner of a m x n grid (marked 'Start' in
 * the diagram below).
 * 
 * The robot can only move either down or right at any point in time. The robot
 * is trying to reach the bottom-right corner of the grid (marked 'Finish' in
 * the diagram below).
 * 
 * Now consider if some obstacles are added to the grids. How many unique paths
 * would there be?
 * 
 * An obstacle and space is marked as 1 and 0 respectively in the grid.
 *
 *
 * Constraints:
 * 
 * m == obstacleGrid.length
 * 
 * n == obstacleGrid[i].length
 * 
 * 1 <= m, n <= 100
 * 
 * obstacleGrid[i][j] is 0 or 1.
 */
public class UniquePathsII {
	public static void main(String[] args) {
		int[][] obstacleGrid = { { 0, 0, 0 }, { 0, 1, 0 }, { 0, 0, 0 } };
		System.out.println(uniquePathsWithObstacles(obstacleGrid));
	}

	/**
	 * dp, faster than 100.00%
	 * 
	 * @param obstacleGrid
	 * @return
	 */
	public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
		// 已知m, n必大于0
		int m = obstacleGrid.length;
		int n = obstacleGrid[0].length;
		int[][] dp = new int[m][n];

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				// 该位置有障碍物
				if (obstacleGrid[i][j] == 1) {
					dp[i][j] = 0;
				} else {
					if (i == 0 && j == 0) {
						// 起点必须为1
						dp[0][0] = 1;
					} else if (i == 0 && j > 0) {
						// 第一行
						dp[i][j] = dp[i][j - 1];
					} else if (i > 0 && j == 0) {
						// 第一列
						dp[i][j] = dp[i - 1][j];
					} else {
						dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
					}
				}
			}
		}

		return dp[m - 1][n - 1];
	}
}
