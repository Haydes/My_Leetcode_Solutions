package Easy;

import java.util.Scanner;

/**
 * 9. Palindrome Number
 * Determine whether an integer is a palindrome. An integer is a palindrome when
 * it reads the same backward as forward. Coud you solve it without converting
 * the integer to a string?
 *
 */
public class PalindromeNumber {
	public static void main(String[] args) {
		System.out.println("Please input a num:");
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		if (isPalindrome(num)) {
			System.out.println("the num is Palindrome!");
		} else {
			System.out.println("the num is not Palindrome!");
		}
		
	}

	public static boolean isPalindrome(int x) {
		if (x < 0) {
			return false;
		}
		
		int val = 0;
		int xx = x;
		while (xx != 0) {
			val = val * 10 + xx % 10;
			xx /= 10;
		}
		return val == x;
	}
}
