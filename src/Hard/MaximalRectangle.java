package Hard;

import java.util.Stack;

import utils.MyPrinter;

/**
 * 85. Maximal Rectangle
 * 
 * Given a rows x cols binary matrix filled with 0's and 1's, find the largest
 * rectangle containing only 1's and return its area.
 *
 */
public class MaximalRectangle {
	public static void main(String[] args) {
		char[][] matrix = { { '1', '0', '1', '0', '0' }, { '1', '0', '1', '1', '1' }, { '1', '1', '1', '1', '1' },
				{ '1', '0', '0', '1', '0' } };
		MyPrinter.print2DArray(matrix);
		System.out.println(maximalRectangle2(matrix));
	}

	/**
	 * 借用LargestRectangleHistogram的技巧
	 * 
	 * 11 ms, faster than 35.20%
	 * 
	 * @param matrix
	 * @return
	 */
	public static int maximalRectangle(char[][] matrix) {
		if (matrix == null || matrix.length == 0) {
			return 0;
		}
		int maxArea = 0;

		int m = matrix.length;
		// +1是为了能考虑到最后一个元素n-2，当一直增长时，第n-1为0，就能把第n-2取出stack
		int n = matrix[0].length + 1;
		// h[j] 表示当前位置的bar高度
		int[] h = new int[n];

		for (int i = 0; i < m; i++) {
			Stack<Integer> stack = new Stack<Integer>();
			for (int j = 0; j < n; j++) {
				// h[n-1] = 0
				if (j < n - 1) {
					if (matrix[i][j] == '1') {
						h[j] += 1;
					} else {
						h[j] = 0;
					}
				}

				while (!stack.isEmpty() && h[j] < h[stack.peek()]) {
					int pop = stack.pop();
					int width = stack.isEmpty() ? j : j - stack.peek() - 1;
					maxArea = Math.max(maxArea, h[pop] * width);
				}
				stack.push(j);
			}
		}
		return maxArea;
	}

	/**
	 * Discuss热门解答，目前还没看懂！！！
	 * @param matrix
	 * @return
	 */
	public static int maximalRectangle2(char[][] matrix) {
		if (matrix == null || matrix.length == 0)
			return 0;
		int m = matrix.length;
		int n = matrix[0].length;
//		height[i] record the current number of countinous '1' in column i;
		// left[i]表示在left[i]到i范围内的所有位置的高度都大于等于height[i]
		int[] left = new int[n];
		// right[i]表示在i到right[i]范围内所有位置的高度都大于等于height[i]
		int[] right = new int[n];
		int[] height = new int[n];
		int maxA = 0;
		for (int i = 0; i < m; i++) {
			int cur_left = 0, cur_right = n;
			for (int j = 0; j < n; j++) { // compute height (can do this from either side)
				if (matrix[i][j] == '1')
					height[j]++;
				else
					height[j] = 0;
			}
			for (int j = 0; j < n; j++) { // compute left (from left to right)
				if (matrix[i][j] == '1')
					left[j] = Math.max(left[j], cur_left);
				else { // matrix[i][j] == '0'
					// 0~j中所有的height都大于0
					left[j] = 0;
					cur_left = j + 1;
				}
			}
			// compute right (from right to left)
			for (int j = n - 1; j >= 0; j--) {
				if (matrix[i][j] == '1')
					right[j] = Math.min(right[j], cur_right);
				else {
					right[j] = n;
					cur_right = j;
				}
			}
			// compute the area of rectangle (can do this from either side)
			for (int j = 0; j < n; j++)
				maxA = Math.max(maxA, (right[j] - left[j]) * height[j]);
		}
		return maxA;
	}

}
