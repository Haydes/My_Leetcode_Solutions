package Hard;

import java.util.Scanner;

/**
 * 44. Wildcard Matching
 * 
 * Given an input string (s) and a pattern (p), implement wildcard pattern
 * matching with support for '?' and '*' where:
 * 
 * '?' Matches any single character.
 * 
 * '*' Matches any sequence of characters (including the empty sequence).
 * 
 * The matching should cover the entire input string (not partial).
 *
 */
public class WildcardMatching {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Please input a string:");
		String str = sc.nextLine();
		System.out.println("Please input a pattern:");
		String pattern = sc.nextLine();
		sc.close();
		boolean match = isMatch(str, pattern);
		if (match) {
			System.out.println("Match!");
		} else {
			System.out.println("Not match!");
		}

	}

	/**
	 * 2D match array, faster than 76.41%
	 * 
	 * @param s
	 * @param p
	 * @return
	 */
	public static boolean isMatch(String s, String p) {
		char[] sArray = s.toCharArray();
		char[] pArray = p.toCharArray();
		// every element is false by default
		boolean[][] wildcardMatch = new boolean[sArray.length + 1][pArray.length + 1];

		// empty s match empty p
		wildcardMatch[0][0] = true;
		// empty p should not match any not empty s, wildcardMatch[s][0] should be false
		// if s > 0

		// empty s match p length i+1
		for (int i = 0; i < pArray.length; i++) {
			if (pArray[i] == '*') {
				wildcardMatch[0][i + 1] = true;
			} else {
				break;
			}
		}

		//
		for (int i = 0; i < sArray.length; i++) {
			for (int j = 0; j < pArray.length; j++) {
				if (pArray[j] == '?' || pArray[j] == sArray[i]) {
					wildcardMatch[i + 1][j + 1] = wildcardMatch[i][j];
				} else if (pArray[j] == '*') {
					wildcardMatch[i + 1][j + 1] = (wildcardMatch[i][j + 1] || wildcardMatch[i + 1][j]);
				} else {
					wildcardMatch[i + 1][j + 1] = false;
				}
			}
		}

		return wildcardMatch[sArray.length][pArray.length];
	}
}
