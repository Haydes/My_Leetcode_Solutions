package Hard;

import java.util.HashMap;
import java.util.Map;

/**
 * 65. Valid Number
 * 
 * A valid number can be split up into these components (in order):
 * 
 * 1. A decimal number or an integer.
 * 
 * 2. (Optional) An 'e' or 'E', followed by an integer.
 * 
 * 
 * A decimal number can be split up into these components (in order):
 * 
 * 1. (Optional) A sign character (either '+' or '-').
 * 
 * 2. One of the following formats:
 * 
 * (1) At least one digit, followed by a dot '.'.
 * 
 * (2) At least one digit, followed by a dot '.', followed by at least one
 * digit.
 * 
 * (3) A dot '.', followed by at least one digit.
 * 
 * An integer can be split up into these components (in order):
 * 
 * 1. (Optional) A sign character (either '+' or '-').
 * 
 * 2. At least one digit.
 * 
 * For example, all the following are valid numbers: ["2", "0089", "-0.1",
 * "+3.14", "4.", "-.9", "2e10", "-90E3", "3e+7", "+6e-1", "53.5e93",
 * "-123.456e789"], while the following are not valid numbers: ["abc", "1a",
 * "1e", "e3", "99e2.5", "--6", "-+3", "95a54e53"].
 * 
 * Given a string s, return true if s is a valid number.
 *
 */
public class ValidNumber {
	public static void main(String[] args) {
		System.out.println(isNumber("1E9"));
	}

	/**
	 * DFA, 5 ms, faster than 21.91%
	 * 
	 * @param s
	 * @return
	 */
	public static boolean isNumber(String s) {
		// 去除字符串两端可能存在的空格
		s = s.trim();
		// generate a DFA, init state = 0, action={sign,e,.,digit},accept
		// state={1,4,5,8}
		Map<Integer, Map<String, Integer>> dfa = generateDFA();
		int currentState = 0;
		char[] sArray = s.toCharArray();
		String action;
		for (char c : sArray) {
			if (c >= '0' && c <= '9') {
				action = "digit";
			} else if (c == '.') {
				action = ".";
			} else if (c == 'e' || c == 'E') {
				action = "e";
			} else if (c == '+' || c == '-') {
				action = "sign";
			} else {
				return false;
			}
			if (dfa.get(currentState).get(action) == null) {
				return false;
			} else {
				currentState = dfa.get(currentState).get(action);
			}
		}

		if (currentState == 1 || currentState == 4 || currentState == 5 || currentState == 8) {
			return true;
		}
		return false;
	}

	public static Map<Integer, Map<String, Integer>> generateDFA() {
		// 定义一个DFA
		Map<Integer, Map<String, Integer>> dfa = new HashMap<Integer, Map<String, Integer>>();
		for (int i = 0; i < 9; i++) {
			dfa.put(i, new HashMap<String, Integer>());
		}
		dfa.get(0).put("digit", 1);
		dfa.get(0).put("sign", 2);
		dfa.get(0).put(".", 3);

		// 可接受
		dfa.get(1).put("digit", 1);
		dfa.get(1).put(".", 4);
		dfa.get(1).put("e", 6);

		dfa.get(2).put("digit", 1);
		dfa.get(2).put(".", 3);

		dfa.get(3).put("digit", 8);

		// 可接受
		dfa.get(4).put("digit", 8);
		dfa.get(4).put("e", 6);

		// 可接受
		dfa.get(5).put("digit", 5);

		dfa.get(6).put("digit", 5);
		dfa.get(6).put("sign", 7);

		dfa.get(7).put("digit", 5);

		// 可接受
		dfa.get(8).put("digit", 8);
		dfa.get(8).put("e", 6);

		return dfa;
	}

	/**
	 * 2 ms, faster than 81.20%
	 * @param s
	 * @return
	 */
	public boolean isNumber2(String s) {
		s = s.trim();

		boolean pointSeen = false;
		boolean eSeen = false;
		boolean numberSeen = false;
		boolean numberAfterE = true;
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) >= '0' && s.charAt(i) <= '9') {
				numberSeen = true;
				numberAfterE = true;
			} else if (s.charAt(i) == '.') {
				if (eSeen || pointSeen) {
					return false;
				}
				pointSeen = true;
			} else if (s.charAt(i) == 'e' || s.charAt(i) == 'E') {
				if (eSeen || !numberSeen) {
					return false;
				}
				numberAfterE = false;
				eSeen = true;
			} else if (s.charAt(i) == '+' || s.charAt(i) == '-') {
				if (i != 0 && (s.charAt(i - 1) != 'e' && s.charAt(i - 1) != 'E')) {
					return false;
				}
			} else {
				return false;
			}
		}
		return numberSeen && numberAfterE;
	}
}
