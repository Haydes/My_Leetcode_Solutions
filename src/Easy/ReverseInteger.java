package Easy;

import java.util.Scanner;

/**
 * 7. Reverse Integer
 * Given a 32-bit signed integer, reverse digits of an integer. Assume we are
 * dealing with an environment which could only store integers within the 32-bit
 * signed integer range: [−231, 231 − 1]. For the purpose of this problem,
 * assume that your function returns 0 when the reversed integer overflows.
 */
public class ReverseInteger {
	public static void main(String[] args) {
		int integer;
		Scanner sc = new Scanner(System.in);

		System.out.println("please input an integer:");
		integer = sc.nextInt();

		int reversedInt = reverse(integer);
		System.out.println("reverse integer:" + reversedInt);
	}

	public static int reverse(int x) {
		int result = 0;
		while (x != 0) {
			int pop = x % 10;
			x /= 10;

			if ((result > Integer.MAX_VALUE / 10) || ((result == Integer.MAX_VALUE / 10) && pop > 7)) {
				return 0;
			} else if ((result < Integer.MIN_VALUE / 10) || ((result == Integer.MIN_VALUE / 10) && pop < -8)) {
				return 0;
			}
			result = result * 10 + pop;
		}
		return result;
	}
}
