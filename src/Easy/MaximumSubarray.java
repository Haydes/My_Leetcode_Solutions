package Easy;

/**
 * 53. Maximum Subarray
 * 
 * Given an integer array nums, find the contiguous subarray (containing at
 * least one number) which has the largest sum and return its sum.
 *
 */
public class MaximumSubarray {
	public static void main(String[] args) {
		int[] nums = { -2, 1, -3, 4, -1, 2, 1, -5, 4 };
		System.out.println(maxSubArray2(nums));
	}

	/**
	 * 暴力法, faster than 5.03%
	 * 
	 * @param nums
	 * @return
	 */
	public static int maxSubArray(int[] nums) {
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < nums.length; i++) {
			int sum = 0;
			for (int j = i; j < nums.length; j++) {
				sum += nums[j];
				if (sum > max) {
					max = sum;
				}
			}
		}
		return max;
	}

	/**
	 * DP, faster than 100%
	 * 
	 * @param nums
	 * @return
	 */
	public static int maxSubArray2(int[] nums) {
		int max = Integer.MIN_VALUE;
		int sum = 0;
		for (int i = 0; i < nums.length; i++) {
			sum += nums[i];
			if (sum < nums[i]) {
				sum = nums[i];
			}
			if (sum > max) {
				max = sum;
			}
		}
		return max;
	}
}
