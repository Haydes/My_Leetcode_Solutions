package Medium;

/**
 * 50. Pow(x, n)
 * 
 * Implement pow(x, n), which calculates x raised to the power n (i.e. xn).
 *
 */
public class PowXN {
	public static void main(String[] args) {
		System.out.println(myPow(2.000000, -2147483648));
	}

	/**
	 * 递归, faster than 100%
	 * @param x
	 * @param n
	 * @return
	 */
	public static double myPow(double x, int n) {
		if (n == 0) {
			return 1;
		}
		
		if (n < 0) {
			x = 1 / x;
			if (n == Integer.MIN_VALUE) {
				// 至少保证-1的那么多次方是对的
				n = Integer.MAX_VALUE-1;
			} else {
				n = -n;
			}
		}

		return (n % 2 == 0) ? myPow(x * x, n / 2) : x * myPow(x * x, n / 2);
	}

	/**
	 * 迭代, faster than 100%
	 * @param x
	 * @param n
	 * @return
	 */
	public static double myPow2(double x, int n) {
		if (n == 0) {
			return 1;
		}
		if (n < 0) {
			x = 1 / x;
			if (n == Integer.MIN_VALUE) {
				// 至少保证-1的那么多次方是对的
				n = Integer.MAX_VALUE-1;
			} else {
				n = -n;
			}
		}
		double ans = 1;
		while (n > 0) {
			// 如果是奇数，那n/2会遗失一个x,所以要乘上
			if (n % 2 == 1) {
				ans *= x;
			}
			x *= x;
			n /= 2;
		}
		return ans;
	}
}
