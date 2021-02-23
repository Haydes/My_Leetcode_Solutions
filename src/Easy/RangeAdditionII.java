package Easy;

/**
 * 598. Range Addition II
 * 
 * You are given an m x n matrix M initialized with all 0's and an array of
 * operations ops, where ops[i] = [ai, bi] means M[x][y] should be incremented
 * by one for all 0 <= x < ai and 0 <= y < bi.
 * 
 * Count and return the number of maximum integers in the matrix after
 * performing all the operations.
 *
 */
public class RangeAdditionII {
	public static void main(String[] args) {
		int m = 40000;
		int n = 40000;
		int[][] ops = { { 2, 2 }, { 3, 3 } };
		int maxCount = maxCount(m, n, ops);
		System.out.println(maxCount);
	}

	/**
	 * faster than 100.00%
	 * @param m
	 * @param n
	 * @param ops
	 * @return
	 */
	public static int maxCount(int m, int n, int[][] ops) {
		int ai = m;
		int bi = n;
		for (int i = 0; i < ops.length; i++) {
			if (ops[i][0] < ai) {
				ai = ops[i][0];
			}
			if (ops[i][1] < bi) {
				bi = ops[i][1];
			}
		}

		return ai * bi;
	}
}
