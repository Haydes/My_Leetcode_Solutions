package Hard;

import java.util.Stack;

/**
 * 84. Largest Rectangle in Histogram
 * 
 * Given n non-negative integers representing the histogram's bar height where
 * the width of each bar is 1, find the area of largest rectangle in the
 * histogram.
 *
 * 
 * 
 */
public class LargestRectangleInHistogram {
	public static void main(String[] args) {
		int[] heights = { 2, 2, 4 };
		System.out.println(largestRectangleArea(heights));
	}

	/**
	 * stack, 30 ms, faster than 38.69%
	 * 
	 * @param heights
	 * @return
	 */
	public static int largestRectangleArea(int[] heights) {
		int maxArea = 0;
		Stack<Integer> stack = new Stack<Integer>();
//		for (int i = 0; i <= heights.length; i++) {
//			int h = (i == heights.length) ? 0 : heights[i];
//			// 只有当前遍历的数大于等于栈顶元素，才会入栈
//			if (stack.isEmpty() || heights[stack.peek()] <= h) {
//				stack.push(i);
//			} else { // 当前遍历到的元素小于栈顶元素
//				// 当前高度
//				int currentH = heights[stack.pop()];
//				// width = 右边界-左边界+1
//				// heights[i]小于currentH, i-1是最后一个高度大于等于currentH的bar
//				// heights[stack.peek()]比currentH小, 所以是左边界是stack.peek()+1
//				// 所以width = (i-1)-(stack.peek()+1)+1 = i-stack.peek()-1
//				// 如果栈已经被取空了，那表示没有bar比currentH的高度低，所以为i-1-0+1=i
//				int width = stack.isEmpty() ? i : i - 1 - stack.peek();
//				maxArea = Math.max(maxArea, currentH * width);
//				// 需要再次判断当前bar是否比栈顶元素大
//				i--;
//			}
//		}

		for (int i = 0; i <= heights.length; i++) {
			int h = (i == heights.length) ? 0 : heights[i];
			while (!stack.isEmpty() && heights[stack.peek()] > h) {
				int currentH = heights[stack.pop()];
				int width = stack.isEmpty() ? i : i - 1 - stack.peek();
				maxArea = Math.max(maxArea, currentH * width);
			}
			stack.push(i);
		}
		return maxArea;
	}

	/**
	 * 通过每个柱子的高度乘以可以使用的最大宽度得到每个柱子高度下的最大值
	 * 
	 * 7 ms, faster than 82.92%
	 * 
	 * @param heights
	 * @return
	 */
	public static int largestRectangleArea2(int[] heights) {
		int maxArea = 0;
		// firstLeft[i]表示i bar左边第一个比它矮的bar(从i往左数)
		int[] firstLeft = new int[heights.length];
		int[] firstRight = new int[heights.length];

		firstLeft[0] = -1;
		firstRight[heights.length - 1] = heights.length;

		for (int i = 1; i < firstRight.length; i++) {
			int p = i - 1;
			while (p >= 0 && heights[p] >= heights[i]) {
				// 比p--快
				p = firstLeft[p];
			}
			firstLeft[i] = p;
		}

		for (int i = heights.length - 2; i >= 0; i--) {
			int p = i + 1;
			while (p < heights.length && heights[p] >= heights[i]) {
				p = firstRight[p];
			}
			firstRight[i] = p;
		}

		for (int i = 0; i < heights.length; i++) {
			// 左边界fistLeft+1 右边界firstRight-1
			// width = (firstRight[i]-1)-(fistLeft[i]+1)+1
			int width = firstRight[i] - 1 - firstLeft[i];
			maxArea = Math.max(maxArea, heights[i] * width);
		}
		return maxArea;
	}

}
