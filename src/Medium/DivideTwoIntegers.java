package Medium;

/**
 * 29. Divide Two Integers
 * 
 * Given two integers dividend and divisor, divide two integers without using
 * multiplication, division, and mod operator.
 * 
 * Return the quotient after dividing dividend by divisor.
 * 
 * The integer division should truncate toward zero, which means losing its
 * fractional part. For example, truncate(8.345) = 8 and truncate(-2.7335) = -2.
 *
 */
public class DivideTwoIntegers {
	public static void main(String[] args) {
		int result = divide(-2147483648, 1);
		System.out.println(result);
	}

	/**
	 * faster than 100%
	 * 
	 * @param dividend
	 * @param divisor
	 * @return
	 */
	public static int divide(int dividend, int divisor) {
		if (dividend == Integer.MIN_VALUE && divisor == -1) {
			return Integer.MAX_VALUE;
		}
		// ^代表异或XOR，两个不同则为true
		boolean neg = (dividend < 0) ^ (divisor < 0);
		//abs() 里面要传long类型才不会返回的是int然后转的long
		long ldd = Math.abs((long)dividend);
		long ldr = Math.abs((long)divisor);

		int count = 0;
		while (ldd >= ldr) {
			// multiple 代表倍数
			long temp = ldr, multiple = 1;
			// 左移一位相当于*2
			while (ldd >= (temp << 1)) {
				temp <<= 1;
				multiple <<= 1;
			}
			ldd -= temp;
			count += multiple;
		}
		return neg ? -count : count;
	}
}
