package Medium;

import java.util.ArrayList;
import java.util.List;

/**
 * 36. Valid Sudoku
 * 
 * Determine if a 9 x 9 Sudoku board is valid. Only the filled cells need to be
 * validated according to the following rules:
 * 
 * 1. Each row must contain the digits 1-9 without repetition.
 * 
 * 2. Each column must contain the digits 1-9 without repetition.
 * 
 * 3. Each of the nine 3 x 3 sub-boxes of the grid must contain the digits 1-9
 * without repetition.
 * 
 * Note:
 * 
 * A Sudoku board (partially filled) could be valid but is not necessarily
 * solvable.
 * 
 * Only the filled cells need to be validated according to the mentioned rules.
 */
public class ValidSudoku {
	public static void main(String[] args) {
		char[][] board = { { '9', '3', '.', '.', '7', '.', '.', '.', '.' },
				{ '6', '.', '.', '1', '9', '5', '.', '.', '.' }, { '.', '9', '8', '.', '.', '.', '.', '6', '.' },
				{ '8', '.', '.', '.', '6', '.', '.', '.', '3' }, { '4', '.', '.', '8', '.', '3', '.', '.', '1' },
				{ '7', '.', '.', '.', '2', '.', '.', '.', '6' }, { '.', '6', '.', '.', '.', '.', '2', '8', '.' },
				{ '.', '.', '.', '4', '1', '9', '.', '.', '5' }, { '.', '.', '.', '.', '8', '.', '.', '7', '9' } };
		boolean validSudoku = isValidSudoku(board);
		System.out.println(validSudoku);

	}

	/**
	 * faster than 82.73%
	 * 
	 * @param board
	 * @return
	 */
	public static boolean isValidSudoku(char[][] board) {
		// 存9宫格的list
		List<List<Character>> lists = new ArrayList<List<Character>>();
		for (int i = 0; i < 9; i++) {
			lists.add(new ArrayList<Character>());
		}
		for (int i = 0; i < 9; i++) {
			// 横的list
			List<Character> list_r = new ArrayList<Character>();
			// 竖的list
			List<Character> list_c = new ArrayList<Character>();

			for (int j = 0; j < 9; j++) {
				// 横的判断
				char ch_r = board[i][j];
				// ’.‘ 表示该格子未填充
				if (ch_r != '.') {
					if (ch_r >= '1' && ch_r <= '9') {
						if (list_r.contains(ch_r)) {
							return false;
						} else {
							list_r.add(ch_r);
						}
					} else {
						return false;
					}
				}

				// 竖的判断
				char ch_c = board[j][i];
				// ’.‘ 表示该格子未填充
				if (ch_c != '.') {
					if (ch_c >= '1' && ch_c <= '9') {
						if (list_c.contains(ch_c)) {
							return false;
						} else {
							list_c.add(ch_c);
						}
					} else {
						return false;
					}
				}

				char ch = board[i][j];
				if (ch == '.') {
					continue;
				}

				// 9宫格区块判断，从0~8共9个list
				// 当前元素属于的list索引为row/3*3+col/3
				int box_index = i/3*3+j/3;
				if (lists.get(box_index).contains(ch)) {
					return false;
				} else {
					lists.get(box_index).add(ch);
				}

			}
		}
		return true;
	}
}
