package Medium;

import java.util.Scanner;

/**
 * 8. String to Integer (atoi)
 * 
 * Implement atoi which converts a string to an integer. The function first
 * discards as many whitespace characters as necessary until the first
 * non-whitespace character is found. Then, starting from this character, takes
 * an optional initial plus or minus sign followed by as many numerical digits
 * as possible, and interprets them as a numerical value. The string can contain
 * additional characters after those that form the integral number, which are
 * ignored and have no effect on the behavior of this function. If the first
 * sequence of non-whitespace characters in str is not a valid integral number,
 * or if no such sequence exists because either str is empty or it contains only
 * whitespace characters, no conversion is performed. If no valid conversion
 * could be performed, a zero value is returned.
 *
 */
public class StringToIntegerAtoi {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Please input a string:");
		String str = sc.nextLine();
		int num = myAtoi(str);
		System.out.println(num);

	}

	public static int myAtoi(String str) {
		long val = 0;
		char sign = '+';
		int hasSign = 0;
		boolean hasNumber = false;

		for (char ch : str.toCharArray()) {
			if (ch == ' ') {
				if (hasNumber || hasSign == 1) {
					break;
				}
				continue;
			} else if (ch == '+' || ch == '-') {
				if (hasNumber) {
					break;
				}
				hasSign++;
				if (hasSign > 1) {
					break;
				}
				sign = ch;
			} else if (ch >= '0' && ch <= '9') {
				hasNumber = true;
				val = val * 10 + ((int) ch - 48);
				if (val >= Integer.MAX_VALUE || val * (-1) <= Integer.MIN_VALUE) {
					break;
				}
			} else { // other letters
				break;
			}
		}

		if (sign == '-') {
			val *= -1;
		}

		if (val > Integer.MAX_VALUE) {
			return Integer.MAX_VALUE;
		} else if (val < Integer.MIN_VALUE) {
			return Integer.MIN_VALUE;
		}

		return (int) val;
	}
}
