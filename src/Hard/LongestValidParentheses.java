package Hard;

import java.util.Stack;

/**
 * 
 * 32. Longest Valid Parentheses
 * 
 * Given a string containing just the characters '(' and ')', find the length of
 * the longest valid (well-formed) parentheses substring.
 *
 */
public class LongestValidParentheses {
	public static void main(String[] args) {
		String str = "(()()";
//		String str = "(()";
		int longestValidParentheses = longestValidParentheses(str);
		System.out.println(longestValidParentheses);
	}

	/**
	 * faster than 67.09%
	 * 
	 * @param s
	 * @return
	 */
	public static int longestValidParentheses(String s) {
		// 用于记录当前的长度
		int currentLen = 0;
		// 用于记录最大长度
		int max = 0;
		// 用于记录当前起始的index
		int start = -1;
		// 栈中记录index
		Stack<Integer> stack = new Stack<Integer>();
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '(') {
				stack.push(i);
			} else { // 这时候是")"
				if (stack.isEmpty()) {
					start = i;
				} else {
					stack.pop();

					if (stack.isEmpty()) {
						// 从start后一个开始到i一直都是有效的
						currentLen = i - start;
						if (max < currentLen) {
							max = currentLen;
						}
					} else {
						// stack不为空，只能表示从stack中index到i是有效的
						currentLen = i - stack.peek();
						if (max < currentLen) {
							max = currentLen;
						}
					}
				}
			}
		}
		return max;
	}
}
