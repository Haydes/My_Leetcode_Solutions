package Medium;

/**
 * 74. Search a 2D Matrix
 * 
 * Write an efficient algorithm that searches for a value in an m x n matrix.
 * This matrix has the following properties:
 * 
 * Integers in each row are sorted from left to right. The first integer of each
 * row is greater than the last integer of the previous row.
 *
 */
public class SearchA2DMatrix {
	public static void main(String[] args) {
		int[][] matrix = { { 1, 3, 5, 7 }, { 10, 11, 16, 20 }, { 23, 30, 34, 60 } };
		int target = 3;
		System.out.println(searchMatrix(matrix, target));
	}

	/**
	 * 二分法, 0 ms, faster than 100.00%
	 * 
	 * @param matrix
	 * @param target
	 * @return
	 */
	public static boolean searchMatrix(int[][] matrix, int target) {
		int m = matrix.length;
		int n = matrix[0].length;
		int right = m - 1;
		int left = 0;
		while (left <= right) {
			int mid = left + (right - left) / 2;
			if (matrix[mid][0] > target) {
				right = mid - 1;
			} else if (matrix[mid][0] < target) {
				if (matrix[mid][n - 1] < target) {
					left = left + 1;
				} else if (matrix[mid][n - 1] == target) {
					return true;
				} else { // matrix[mid][0] < target && matrix[mid][n-1] > target
					int rr = n - 1;
					int ll = 0;
					while (ll <= rr) {
						int mm = ll + (rr - ll) / 2;
						if (matrix[mid][mm] == target) {
							return true;
						} else if (matrix[mid][mm] > target) {
							rr = mm - 1;
						} else {
							ll = mm + 1;
						}
					}
					break;
				}
			} else {
				return true;
			}
		}
		return false;
	}
}
