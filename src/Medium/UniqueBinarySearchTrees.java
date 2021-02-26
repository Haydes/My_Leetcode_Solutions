package Medium;

/**
 * 96. Unique Binary Search Trees
 * 
 * Given an integer n, return the number of structurally unique BST's (binary
 * search trees) which has exactly n nodes of unique values from 1 to n.
 * 
 * Constraints:
 * 
 * 1 <= n <= 19
 *
 */
public class UniqueBinarySearchTrees {
	public static void main(String[] args) {
		System.out.println(numTrees(4));
	}

	/**
	 * 0 ms, faster than 100.00%
	 * 
	 * @param n
	 * @return
	 */
	public static int numTrees(int n) {
		// G[i] 表示有i个数字时能产生的BST数量，只需要把1到i所有数字逐个作为root的情况下的数量都加起来
		int[] G = new int[n + 1];
		G[0] = G[1] = 1;
		// G[n] = F(1, n) + F(2, n) +...+ F(n,n)
		// F(i,n) 表示以i为root，有n个数的时候能产生的BST数量, 就等于左半边（比i小的数）数量与右半边（比i大的数）数量的乘积
		// 比i小的数有i-1个，比i大的数有n-i个, i从1开始
		// F(i, n) = G[i-1] * G[n-i]
		// G[n] = G[0]*G[n-1] + G[1]*G[n-2] + ... + G[n-1]*G[0]
		for (int i = 2; i <= n; i++) {
			for (int j = 1; j <= i; j++) {
				G[i] += G[j - 1] * G[i - j];
			}
		}
		return G[n];
	}
}
