package Medium;

import java.util.Scanner;

/**
 * 5. Longest Palindromic Substring
 * 
 * Given a string s, find the longest palindromic substring in s. You may assume
 * that the maximum length of s is 1000.
 *
 */
public class LongestPalindromicSubstring {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String str = scanner.nextLine();

		System.out.println(longestPalindrome2(str));

	}

	public static boolean isPalindromic(String str) {
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) != str.charAt(str.length() - 1 - i)) {
				return false;
			}
		}
		return true;
	}

	public static String longestPalindrome1(String s) {
		int max = 0;
		int start = -1;
		int end = -1;

		if (s == null || s.length() == 0)
			return "";

		for (int i = 0; i < s.length(); i++) {
			for (int j = i; j < s.length(); j++) {
				if (isPalindromic(s.substring(i, j + 1))) {
					if (max < j - i + 1) {
						max = j - i + 1;
						start = i;
						end = j;
					}
				}
			}
		}
		return s.substring(start, end + 1);
	}

	public static String longestPalindrome2(String s) {
		if (s == null || s.length() == 0)
			return "";

		int max = 0;
		int start = -1;
		int end = -1;
		for (int i = 0; i < s.length(); i++) {
			int left = i;
			int right = i;
			int len = 0;
			while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
				left--;
				right++;
			}
			len = right - left - 1;
			if (max < len) {
				max = len;
				start = left + 1;
				end = right - 1;
			}
		}

		for (int i = 0; i < s.length(); i++) {
			int left = i;
			int right = i + 1;
			int len = 0;
			while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
				left--;
				right++;
			}
			len = right - left - 1;
			if (max < len) {
				max = len;
				start = left + 1;
				end = right - 1;
			}

		}

		return s.substring(start, end + 1);
	}
}
