package Medium;

import java.util.Arrays;

/**
 * 198. House Robber
 * 
 * You are a professional robber planning to rob houses along a street. Each
 * house has a certain amount of money stashed, the only constraint stopping you
 * from robbing each of them is that adjacent houses have security system
 * connected and it will automatically contact the police if two adjacent houses
 * were broken into on the same night.
 * 
 * Given a list of non-negative integers representing the amount of money of
 * each house, determine the maximum amount of money you can rob tonight without
 * alerting the police.
 *
 */
public class HouseRobber {
	public static void main(String[] args) {
		int[] nums = { 2, 1, 3, 2 };
		int rob = rob(nums);
		System.out.println(rob);
	}

	/**
	 * 动态规划，迭代
	 * 
	 * faster than 100%
	 * 
	 * @param nums
	 * @return
	 */
	public static int rob(int[] nums) {
		int maxAmount = 0;
		if (nums.length == 0) {
			return maxAmount;
		}
		int[] dp = new int[nums.length];
		if (nums.length == 1) {
			maxAmount = nums[0];
		} else if (nums.length == 2) {
			maxAmount = Math.max(nums[0], nums[1]);
		} else {
			dp[0] = nums[0];
			dp[1] = Math.max(nums[0], nums[1]);
			for (int i = 2; i < dp.length; i++) {
				// 到第i个房子时，最大金额为
				// 第i-2个房子所得最大金额加上这个房子的金额
				// 与第i-1个房子时最大金额相比的较大者
				dp[i] = Math.max(nums[i] + dp[i - 2], dp[i - 1]);
			}
			maxAmount = dp[dp.length - 1];

		}
		return maxAmount;
	}

	/**
	 * 动态规划，递归
	 * 
	 * 需要知道到第i个房子时， rob[i] = Math.max(rob[i-2]+nums[i], rob[i-1])
	 * 
	 * faster than 100%
	 * 
	 * @param nums
	 * @return
	 */
	public static int rob2(int[] nums) {
		int[] memo = new int[nums.length];
		Arrays.fill(memo, -1);
		return robRec(nums, nums.length - 1, memo);
	}

	/**
	 * recursion
	 * 
	 * @param nums
	 * @param index
	 * @param memo  这个数组存在的意义是为了防止重复计算同一个index的robRec值，否则会超时
	 * @return
	 */
	public static int robRec(int[] nums, int index, int[] memo) {
		if (index < 0) {
			return 0;
		}
		if (memo[index] >= 0) {
			return memo[index];
		} else {
			memo[index] = Math.max(robRec(nums, index - 2, memo) + nums[index], robRec(nums, index - 1, memo));
			return memo[index];
		}
	}

}
