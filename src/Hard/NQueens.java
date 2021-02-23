package Hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 51. N-Queens
 *
 * The n-queens puzzle is the problem of placing n queens on an n x n chessboard
 * such that no two queens attack each other.
 * 
 * Given an integer n, return all distinct solutions to the n-queens puzzle.
 * 
 * Each solution contains a distinct board configuration of the n-queens'
 * placement, where 'Q' and '.' both indicate a queen and an empty space,
 * respectively.
 */
public class NQueens {
	public static void main(String[] args) {
		List<List<String>> solveNQueens = solveNQueens(5);
		System.out.println(solveNQueens);
	}

	/**
	 * faster than 58.81%
	 * 
	 * @param n
	 * @return
	 */
	public static List<List<String>> solveNQueens(int n) {
		List<List<String>> resultList = new ArrayList<List<String>>();
		char[][] board = new char[n][n];
		for (char[] cs : board) {
			Arrays.fill(cs, '.');
		}
		backTrack(resultList, board, n);

		return resultList;
	}

	/**
	 * 回溯法
	 * 
	 * @param resultList
	 * @param board
	 * @param remain     代表剩余要放的棋子数量
	 */
	public static void backTrack(List<List<String>> resultList, char[][] board, int remain) {
		// 控制结束条件
		if (remain == 0) {
			// 这里表示棋盘上已经放了4个棋子都没问题，要把二维数组转list
			List<String> list = new ArrayList<String>();
			for (char[] cs : board) {
				// 代表棋盘中的一行
				String str = String.valueOf(cs);
				// 添加进集合
				list.add(str);
			}
			resultList.add(list);
		}
		// back track
		// 只做一个循环的原因是, 通过观察，每一行必须有且只有一个棋子，所以对于每一行，只需要遍历列就行了
		for (int i = 0; i < board.length; i++) {
			// 当前行为board.length-remain
			if (isNotUnderAttack(board, board.length - remain, i)) {
				board[board.length - remain][i] = 'Q';
				backTrack(resultList, board, remain - 1);
				board[board.length - remain][i] = '.';
			}
		}
	}

	/**
	 * 判断新放置Queen的点x,y是否在不受攻击
	 * 
	 * @param board
	 * @param x
	 * @param y
	 * @return
	 */
	public static boolean isNotUnderAttack(char[][] board, int x, int y) {
		int size = board.length;
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				/*
				 * 同一行: i == x 同一列: j == y 同一左斜线: i+j == x+y 同一右斜线: i-j == x-y
				 * 
				 * 和board[i][j] =='Q'顺序换过来速度会下降到 faster than 38.32%
				 */
				if (board[i][j] == 'Q' && (i == x || j == y || i + j == x + y || i - j == x - y)) {
					return false;
				}
			}
		}
		return true;
	}
}
