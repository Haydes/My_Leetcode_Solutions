package Easy;

import java.util.Scanner;

/**
 * 14. Longest Common Prefix
 * 
 * Write a function to find the longest common prefix string amongst an array of
 * strings. If there is no common prefix, return an empty string "".
 * 
 * All given inputs are in lowercase letters a-z.
 */
public class LongestCommonPrefix {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Please input a length for the array:");
		int len = sc.nextInt();
		String array[] = new String[len];
		for (int i = 0; i < array.length; i++) {
			System.out.println("Please input the " + (i + 1) + " element for the array:");
			array[i] = sc.next();
		}

		System.out.println("The longest common prefix for the array is:\n" + longestCommonPrefix(array));

	}

	public static String longestCommonPrefix(String[] strs) {
		if (strs.length < 1) {
			return "";
		}
		StringBuilder str = new StringBuilder();

		int minLen = strs[0].length();
		for (String string : strs) {
			if (string.length() < minLen) {
				minLen = string.length();
			}
		}

		if (minLen == 0) {
			return "";
		}

		for (int i = 0; i < minLen; i++) {
			int count = 0;
			char common = strs[0].charAt(i);
			for (String string : strs) {
				if (string.charAt(i) == common) {
					count++;
				}
			}
			if (count == strs.length) {
				str.append(common);
			} else {
				break;
			}
		}
		return str.toString();
	}
}
