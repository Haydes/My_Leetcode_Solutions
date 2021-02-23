package Easy;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * 20. Valid Parentheses
 * 
 * Given a string s containing just the characters '(', ')', '{', '}', '[' and
 * ']', determine if the input string is valid.
 * 
 * 
 * An input string is valid if: Open brackets must be closed by the same type of
 * brackets. Open brackets must be closed in the correct order.
 *
 */
public class ValidParentheses {
	public static void main(String[] args) {
		String str = "({})";
		System.out.println(isValid2(str));
	}

	/**
	 * faster than 98.97%
	 * 
	 * @param s
	 * @return
	 */
	public static boolean isValid(String s) {
		char[] leftP = { '(', '[', '{' };
		char[] rightP = { ')', ']', '}' };
		boolean isLeft = false;
		Stack<Integer> stack = new Stack<Integer>();
		for (int i = 0; i < s.length(); i++) {
			char ch = s.charAt(i);
			for (int j = 0; j < leftP.length; j++) {
				if (ch == leftP[j]) {
					stack.push(j);
					isLeft = true;
					break;
				}
			}
			if (!isLeft) {
				for (int j = 0; j < rightP.length; j++) {
					if (ch == rightP[j]) {
						if (stack.isEmpty()) {
							return false;
						}
						int pop = stack.pop();
						if (pop != j) {
							return false;
						}
						break;
					}
				}
			}
			isLeft = false;
		}
		if (stack.isEmpty()) {
			return true;
		}
		return false;
	}

	/**
	 * faster than 98.97%
	 * 
	 * @param s
	 * @return
	 */
	public static boolean isValid2(String s) {
		Map<Character, Character> map = new HashMap<Character, Character>();
		map.put('(', ')');
		map.put('[', ']');
		map.put('{', '}');
		Stack<Character> stack = new Stack<Character>();
		for (int i = 0; i < s.length(); i++) {
			char ch = s.charAt(i);
			// left parentheses, push
			if (map.containsKey(ch)) {
				stack.push(ch);
			} else {
				// right parentheses, pop
				if (stack.isEmpty() || map.get(stack.pop()) != ch) {
					return false;
				}
			}
		}
		if (stack.isEmpty()) {
			return true;
		}
		return false;
	}
}
