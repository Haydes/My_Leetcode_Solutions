package Medium;

/**
 * 62. Unique Paths
 * 
 * A robot is located at the top-left corner of a m x n grid (marked 'Start' in
 * the diagram below).
 * 
 * The robot can only move either down or right at any point in time. The robot
 * is trying to reach the bottom-right corner of the grid (marked 'Finish' in
 * the diagram below).
 * 
 * How many possible unique paths are there?
 *
 */
public class UniquePaths {
	public static void main(String[] args) {
		System.out.println(uniquePaths2(3, 7));
	}

	/**
	 * 组合公式， faster than 100%
	 * 
	 * @param m
	 * @param n
	 * @return
	 */
	public static int uniquePaths(int m, int n) {
		if (m == 1 || n == 1)
			return 1;
		m--;
		n--;
		if (m < n) {
			// Swap, so that m is the bigger number
			m = m + n;
			n = m - n;
			m = m - n;
		}
		long res = 1;
		int j = 1;
		for (int i = m + 1; i <= m + n; i++, j++) {
			// Instead of taking factorial, keep on multiply & divide
			// 这里能防止可能出现的(m+n)!过大的问题
			res *= i;
			res /= j;
		}

		return (int) res;
	}

	/**
	 * dynamic programming, faster than 100.00%
	 * 
	 * @param m
	 * @param n
	 * @return
	 */
	public static int uniquePaths2(int m, int n) {
		// dp[i][j]表示从（0，0）到（i，j）的路径数量 
		int[][] dp = new int[m][n];
		dp[0][0] = 1;
		// 第一排和第一列都为1
		for (int i = 0; i < m; i++) {
			dp[i][0] = 1;
		}
		for (int i = 0; i < n; i++) {
			dp[0][i] = 1;
		}
		
		// 到(i,j)的路径数量应该是其左边和上边所有路径之和
		for (int i = 1; i < m; i++) {
			for (int j = 1; j < n; j++) {
				dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
			}
		}
		return dp[m - 1][n - 1];
	}
}
