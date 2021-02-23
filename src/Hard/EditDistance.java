package Hard;

/**
 * 72. Edit Distance
 * 
 * Given two strings word1 and word2, return the minimum number of operations
 * required to convert word1 to word2.
 * 
 * You have the following three operations permitted on a word:
 * 
 * Insert a character
 * 
 * Delete a character
 * 
 * Replace a character
 * 
 */
public class EditDistance {
	public static void main(String[] args) {
		String word1 = "horse";
		String word2 = "ros";
		System.out.println(minDistance(word1, word2));
	}

	/**
	 * dp, 4 ms, faster than 91.82%
	 * 
	 * @param word1
	 * @param word2
	 * @return
	 */
	public static int minDistance(String word1, String word2) {
		int m = word1.length();
		int n = word2.length();
		// dp[i][j] 表示word1前i个字符匹配word2前j个字符的最小步数
		int[][] dp = new int[m + 1][n + 1];
		// 空字符串匹配空字符串需要的步数
		dp[0][0] = 0;
		// 0个字符匹配i个字符的最小步数为i
		for (int i = 1; i <= m; i++) {
			dp[i][0] = i;
		}
		// 0个字符匹配i个字符的最小步数为i
		for (int i = 1; i <= n; i++) {
			dp[0][i] = i;
		}
		for (int i = 1; i <= m; i++) {
			for (int j = 1; j <= n; j++) {
				// 这里减一是因为索引从0开始，而我们第i个字符就用i表示
				char ch1 = word1.charAt(i - 1);
				char ch2 = word2.charAt(j - 1);
				if (ch1 == ch2) {
					// 当前字符相等, 则最少步数为到两个词各自前一个字符匹配步数
					dp[i][j] = dp[i - 1][j - 1];
				} else {
					// 当前字符不相等, 可能需要进行删除、增加、修改操作, 也就是比之前的最小步数+1
					// 前i-1个word1字符和前j-1个word2字符相匹配了(经过dp[i-1][j-1]步), 那只要把第i个字符换成第j个就可以了
					// 前i-1个word1字符和前j个word2字符相匹配了(经过dp[i-1][j]步), 那只要把第i个字符删除就可以了
					// 前i个word1字符和前j-1个word2字符相匹配了(经过dp[i][j-1]步), 那只要把第j个字符加上就可以了
					// 所以在判断前i个字符和前j个字符的匹配时，需要找出上述3种情况的步数最小值
					int minPreStep = Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1]));
					dp[i][j] = 1 + minPreStep;
				}
			}
		}

		return dp[m][n];
	}

}
