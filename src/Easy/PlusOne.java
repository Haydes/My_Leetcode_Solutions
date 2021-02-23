package Easy;

import java.util.Arrays;

/**
 * 
 * 66. Plus One
 * 
 * Given a non-empty array of decimal digits representing a non-negative
 * integer, increment one to the integer.
 * 
 * The digits are stored such that the most significant digit is at the head of
 * the list, and each element in the array contains a single digit.
 * 
 * You may assume the integer does not contain any leading zero, except the
 * number 0 itself.
 * 
 *
 */
public class PlusOne {
	public static void main(String[] args) {
		int[] digits = { 1, 2, 3 };
		System.out.println(Arrays.toString(plusOne(digits)));
	}

	/**
	 * faster than 100.00%
	 * @param digits
	 * @return
	 */
	public static int[] plusOne(int[] digits) {
		for (int i = 0; i < digits.length; i++) {
			if (digits[digits.length - 1 - i] == 9) {
				digits[digits.length - 1 - i] = 0;
			} else {
				digits[digits.length - 1 - i]++;
				return digits;
			}
		}
		//能走到这里说明digits每一位都为0
		int[] result = new int[digits.length + 1];
		result[0] = 1;
		return result;
	}
}
