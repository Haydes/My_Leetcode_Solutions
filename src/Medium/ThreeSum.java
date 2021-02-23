package Medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

/**
 * 15. 3Sum
 * Given an array nums of n integers, are there elements a, b, c in nums such
 * that a + b + c = 0? Find all unique triplets in the array which gives the sum
 * of zero. The solution set must not contain duplicate triplets.
 *
 */
public class ThreeSum {
	public static void main(String[] args) {
		int array[] = { -1, 0, 1, 2, 1, -1, -4, -2};
		System.out.println(threeSum(array));
	}

	public static List<List<Integer>> threeSum(int[] nums) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		Arrays.sort(nums);
		for (int i = 0; i < nums.length - 2; i++) {
			if (i == 0 || (i > 0 && nums[i] != nums[i - 1])) {
				int j = i + 1;
				int k = nums.length - 1;
				while (j < k) {
					int sum = nums[i] + nums[j] + nums[k];
					if (sum == 0) {
						List<Integer> list = new ArrayList<Integer>();
						list.add(nums[i]);
						list.add(nums[j]);
						list.add(nums[k]);
						result.add(list);
						while (j < k && nums[k] == nums[k - 1]) {
							k--;
						}
						while (j < k && nums[j] == nums[j + 1]) {
							j++;
						}
						j++;
						k--;
					} else if (sum > 0) {
						k--;
					} else {
						j++;
					}
				}
			}
		}
		return result;
	}
}
