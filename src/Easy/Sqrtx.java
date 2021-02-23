package Easy;

/**
 * 69. Sqrt(x)
 * 
 * Given a non-negative integer x, compute and return the square root of x.
 * 
 * Since the return type is an integer, the decimal digits are truncated, and
 * only the integer part of the result is returned.
 *
 */
public class Sqrtx {
	public static void main(String[] args) {
		System.out.println(mySqrt(2147395599));
	}

	/**
	 * Binary search, faster than 99.98%
	 * 
	 * @param x
	 * @return
	 */
	public static int mySqrt(int x) {
		if (x <= 1) {
			return x;
		}
		int left = 1, right = x / 2;
		int ans = 0;
		while (left <= right) {
			int mid = left + (right - left) / 2;
			// 避免mid*mid数字太大溢出, 并且x/mid得到的int永远小于等于真实结果，所以不会有问题
			if (mid <= x / mid) {
				left = mid + 1;
				ans = mid;
			} else {
				right = mid - 1;
			}
		}
		return ans;
	}
}
