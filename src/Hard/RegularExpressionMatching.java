package Hard;

import java.util.Scanner;

/**
 * 10. Regular Expression Matching
 * 
 * Given an input string (s) and a pattern (p), implement regular expression
 * matching with support for '.' and '*'.
 * 
 * '.' Matches any single character.
 * 
 * '*' Matches zero or more of the preceding element.
 */
public class RegularExpressionMatching {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Please input a string:");
		String str = scanner.nextLine();
		System.out.println("Please input a pattern:");
		String pattern = scanner.nextLine();
		scanner.close();
		if (isMatch(str, pattern)) {
			System.out.println("Match!");
		} else {
			System.out.println("Not match!");
		}
	}

	/**
	 * '.' Matches any single character. '*' Matches zero or more of the preceding
	 * element.
	 * 
	 * @param s
	 * @param p
	 * @return
	 */
	public static boolean isMatch(String s, String p) {
		char[] str = s.toCharArray();
		char[] pArray = p.toCharArray();
		// regMatch[0][0] stands for empty s and empty p
		// regMatch[i][j] means str[i-1] with pattern pArray[j-1];
		boolean[][] regMatch = new boolean[str.length + 1][pArray.length + 1];

		regMatch[0][0] = true;

		if (pArray.length > 0 && pArray[0] == '*') {
			return false;
		}

		// consider all the situation with empty s and not empty pattern
		for (int x = 2; x < pArray.length + 1; x++) {
			if (pArray[x - 1] == '*') { // ever index in str or pArray should be 1 less than the index in regMatch
				regMatch[0][x] = regMatch[0][x - 2]; // means empty str with pattern from pArray[0] to pArray[x-1]
			}
		}

		// if pattern is empty, but s is not empty, that should be false, so
		// regMatch[i][0] should be false, when i>0
		for (int i = 1; i < str.length + 1; i++) {
			for (int j = 1; j < pArray.length + 1; j++) {
				if (str[i - 1] == pArray[j - 1] || pArray[j - 1] == '.') {
					regMatch[i][j] = regMatch[i - 1][j - 1];
				} else if (pArray[j - 1] == '*') {
					if (regMatch[i][j - 2]) {// when a* stands for 0 element
						regMatch[i][j] = regMatch[i][j - 2];
					} else if (pArray[j - 2] == str[i - 1] || pArray[j - 2] == '.') { // a* stands for one or more
																						// elements, compare a to
																						// current str
						regMatch[i][j] = regMatch[i - 1][j]; // compare last str with current pattern
					}
				} else {
					regMatch[i][j] = false;
				}
			}
		}

		return regMatch[str.length][pArray.length];
	}

}
