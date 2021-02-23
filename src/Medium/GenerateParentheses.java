package Medium;

import java.util.ArrayList;
import java.util.List;

/**
 * 22. Generate Parentheses
 * 
 * Given n pairs of parentheses, write a function to generate all combinations
 * of well-formed parentheses.
 * 
 * For example, given n = 3, a solution set is: [ "((()))", "(()())", "(())()",
 * "()(())", "()()()" ]
 */
public class GenerateParentheses {
	public static void main(String[] args) {
		System.out.println(generateParenthesis(3));
	}

	public static List<String> generateParenthesis(int n) {
		List<String> list = new ArrayList<String>();
		DFS(n, n, list, "");
		return list;
	}

	/**
	 * Need to review!!!
	 * 
	 * faster than 85.48%
	 * 
	 * @param open
	 * @param close
	 * @param list
	 * @param str
	 */
	public static void DFS(int open, int close, List<String> list, String str) {
		if (open == 0 && close == 0) {
			list.add(str);
			return;
		}

		if (open > 0) {
			String addOpenStr = str + "(";
			DFS(open - 1, close, list, addOpenStr);
		}

		if (close > open) {
			String addCloseStr = str + ")";
			DFS(open, close - 1, list, addCloseStr);
		}
	}
}
