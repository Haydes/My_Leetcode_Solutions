package Easy;

import java.util.Scanner;

/**
 * 58. Length of Last Word
 * 
 * Given a string s consists of some words separated by spaces, return the
 * length of the last word in the string. If the last word does not exist,
 * return 0.
 * 
 * A word is a maximal substring consisting of non-space characters only.
 */
public class LengthOfLastWorld {
	public static void main(String[] args) {
		System.out.println("Please input a string:");
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		int lengthOfLastWord = lengthOfLastWord(str);
		System.out.println("The length of last word is: " + lengthOfLastWord);
	}

	public static int lengthOfLastWord(String s) {
		String[] split = s.split(" ");
		if (split.length == 0) {
			return 0;
		}
		int length = split[split.length - 1].length();
		return length;
	}
}
