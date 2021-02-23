package Hard;

/**
 * 52. N-Queens II
 * 
 * The n-queens puzzle is the problem of placing n queens on an n x n chessboard
 * such that no two queens attack each other.
 * 
 * Given an integer n, return the number of distinct solutions to the n-queens
 * puzzle.
 *
 */
public class NQueensII {
	static int count;
	static boolean[] col = new boolean[9];
	static boolean[] left = new boolean[18]; // 左斜线
	static boolean[] right = new boolean[18]; // 右斜线 x-y要相等，由于可能负数,统一加9

	public static void main(String[] args) {
		System.out.println(totalNQueens(1));
	}

	/**
	 * 回溯法，保存不能放的位置, faster than 78.80%
	 * 
	 * @param n
	 * @return
	 */
	public static int totalNQueens(int n) {
		backTrack(0, n);
		return count;
	}

	public static void backTrack(int row, int size) {
		if (row == size) {
			count++;
		}

		for (int i = 0; i < size; i++) {
			if (isNotUnderAttack(row, i)) {
				col[i] = true;
				left[row + i] = true;
				right[row - i + 9] = true;
				backTrack(row+1,size);
				col[i] = false;
				left[row + i] = false;
				right[row - i + 9] = false;
			}
		}
	}

	public static boolean isNotUnderAttack(int x, int y) {
		if (col[y] || left[x + y] || right[x - y + 9]) { // 任意一项为true表示该位置是受到攻击的
			return false;
		}
		return true;
	}
}
