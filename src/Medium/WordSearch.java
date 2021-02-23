package Medium;

import utils.MyPrinter;

/**
 * 79. Word Search
 * 
 * Given an m x n board and a word, find if the word exists in the grid.
 * 
 * The word can be constructed from letters of sequentially adjacent cells,
 * where "adjacent" cells are horizontally or vertically neighboring. The same
 * letter cell may not be used more than once.
 *
 */
public class WordSearch {
	public static void main(String[] args) {
		char[][] board = { { 'A', 'B', 'C', 'E' }, { 'S', 'F', 'E', 'S' }, { 'A', 'D', 'E', 'E' } };
		MyPrinter.print2DArray(board);
		String word = "ABCESEEEFS";
		System.out.println(exist(board, word));
	}

	/**
	 * dfs, 5 ms, faster than 85.22%
	 * 
	 * @param board
	 * @param word
	 * @return
	 */
	public static boolean exist(char[][] board, String word) {
		if (board.length * board[0].length < word.length()) {
			return false;
		}
		// 这个创建数组不要放进循环里，否则，139 ms, faster than 6.81%
		boolean[][] visited = new boolean[board.length][board[0].length];
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				// 遍历棋盘，只要从任意一个点出发能得到整个串，就成功
				if (existString(board, visited, i, j, word, 0)) {
					return true;
				}
			}
		}
		return false;
	}

	public static boolean existString(char[][] board, boolean[][] visited, int row, int col, String word, int index) {
		if (index == word.length()) {
			return true;
		}
		// 如果索引越界，匹配不成功
		// 如果当前位置字符与字符串不匹配，则该匹配不成功
		// 如果当前位置已访问过，匹配不成功
		if (row < 0 || col < 0 || row >= board.length || col >= board[0].length || visited[row][col]
				|| board[row][col] != word.charAt(index)) {
			return false;
		}
		// 走到这里说明当前字符匹配成功
		index++;
		// 标记为访问过
		visited[row][col] = true;
		// 需要判断临接结点是否能匹配
		boolean isExist = existString(board, visited, row + 1, col, word, index)
				|| existString(board, visited, row - 1, col, word, index)
				|| existString(board, visited, row, col + 1, word, index)
				|| existString(board, visited, row, col - 1, word, index);
		// 取消访问标记（倒退回上一层）
		visited[row][col] = false;
		return isExist;
	}
}
