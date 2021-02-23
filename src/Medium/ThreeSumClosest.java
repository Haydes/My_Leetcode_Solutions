package Medium;

import java.util.Arrays;

/**
 * 16. 3Sum Closest
 * Given an array nums of n integers and an integer target, find three integers
 * in nums such that the sum is closest to target. Return the sum of the three
 * integers. You may assume that each input would have exactly one solution.
 *
 */

public class ThreeSumClosest {
	public static void main(String[] args) {
		int array[] = { 1, 1, -1, -1, 3 };
		System.out.println(threeSumClosest(array, -1));
	}

	public static int threeSumClosest(int[] nums, int target) {
		Arrays.sort(nums);
		int distance = Integer.MAX_VALUE; // make the distance very big initially
		int closestNum = 0;
		for (int i = 0; i < nums.length - 2; i++) {
			if (i == 0 || (i > 0 && nums[i] != nums[i - 1])) {
				int j = i + 1;
				int k = nums.length - 1;
				while (j < k) {
					int sum = nums[i] + nums[j] + nums[k];
					if (sum == target) {
						return target;
					} else if (sum > target) {
						k--;
					} else {
						j++;
					}

					int currentDis = Math.abs(sum - target);
					if (currentDis < distance) {
						distance = currentDis;
						closestNum = sum;
					}

					while (j < k && j > i + 1 && nums[j] == nums[j - 1]) {
						j++;
					}
					while (j < k && k < nums.length - 1 && nums[k] == nums[k + 1]) {
						k--;
					}
				}
			}
		}
		return closestNum;
	}
}
