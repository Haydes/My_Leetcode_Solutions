package Easy;

/**
 * 70. Climbing Stairs
 * 
 * You are climbing a staircase. It takes n steps to reach the top.
 * 
 * Each time you can either climb 1 or 2 steps. In how many distinct ways can
 * you climb to the top?
 *
 */
public class ClimbingStairs {
	public static void main(String[] args) {
		System.out.println(climbStairs(4));
	}
	
	/**
	 * dp, 0 ms, faster than 100.00%
	 * @param n
	 * @return
	 */
	public static int climbStairs(int n) {
		if (n <= 2) {
			return n;
		}
		int[] dp = new int[n];
		dp[0] = 1;
		dp[1] = 2;
		for (int i = 2; i < dp.length; i++) {
			dp[i] = dp[i-1] + dp[i-2];
		}
		
		return dp[n-1];
	}
}
