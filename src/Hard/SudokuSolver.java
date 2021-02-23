package Hard;

/**
 * 37. Sudoku Solver
 * 
 * Write a program to solve a Sudoku puzzle by filling the empty cells.
 * 
 * A sudoku solution must satisfy all of the following rules:
 * 
 * Each of the digits 1-9 must occur exactly once in each row.
 * 
 * Each of the digits 1-9 must occur exactly once in each column.
 * 
 * Each of the digits 1-9 must occur exactly once in each of the 9 3x3 sub-boxes
 * of the grid.
 * 
 * The '.' character indicates empty cells.
 * 
 * Constraints:
 * 
 * board.length == 9
 * 
 * board[i].length == 9
 * 
 * board[i][j] is a digit or '.'.
 * 
 * It is guaranteed that the input board has only one solution.
 */
public class SudokuSolver {
	public static void main(String[] args) {
		char[][] board = { { '5', '3', '.', '.', '7', '.', '.', '.', '.' },
				{ '6', '.', '.', '1', '9', '5', '.', '.', '.' }, { '.', '9', '8', '.', '.', '.', '.', '6', '.' },
				{ '8', '.', '.', '.', '6', '.', '.', '.', '3' }, { '4', '.', '.', '8', '.', '3', '.', '.', '1' },
				{ '7', '.', '.', '.', '2', '.', '.', '.', '6' }, { '.', '6', '.', '.', '.', '.', '2', '8', '.' },
				{ '.', '.', '.', '4', '1', '9', '.', '.', '5' }, { '.', '.', '.', '.', '8', '.', '.', '7', '9' } };
		printSudoku(board);
		solveSudoku(board);
		System.out.println("after solution:");
		printSudoku(board);
	}

	private static void printSudoku(char[][] board) {
		for (int i = 0; i < board.length; i++) {
			if (i % 3 == 0) {
				System.out.println("----------------------");
			}
			for (int j = 0; j < board[0].length; j++) {
				if (j % 3 == 0) {
					System.out.print("|");
				}
				System.out.print(board[i][j] + " ");
				if (j == 8) {
					System.out.print("|");
				}
			}
			System.out.println();
		}
	}

	public static void solveSudoku(char[][] board) {
		solve(board);
	}

	public static boolean solve(char[][] board) {
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				if (board[i][j] == '.') {
					for (char x = '1'; x <= '9'; x++) {
						if (isValid(board, i, j, x)) {
							board[i][j] = x;

							if (solve(board)) {
								return true;
							} else {
								board[i][j] = '.';
							}
						}
					}
					return false;
				}
			}
		}
		return true;
	}

	public static boolean isValid(char[][] board, int row, int column, char fill) {
		boolean isValid = true;
		for (int i = 0; i < board.length; i++) {
			if (board[row][i] == fill) {
				isValid = false;
				break;
			}
			if (board[i][column] == fill) {
				isValid = false;
				break;
			}
			if (board[row / 3 * 3 + i / 3][column / 3 * 3 + i % 3] == fill) {
				isValid = false;
				break;
			}
		}
		return isValid;
	}

}
