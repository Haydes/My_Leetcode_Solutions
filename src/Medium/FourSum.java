package Medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 18. 4Sum
 * Given an array nums of n integers and an integer target, are there elements
 * a, b, c, and d in nums such that a + b + c + d = target? Find all unique
 * quadruplets in the array which gives the sum of target.
 *
 */

//备注：Set无法把[3,2]和[2,3]视为相同元素
public class FourSum {
	public static void main(String[] args) {
		int[] nums = {1, 0, -1, 0, -2, 2};
		int target = 0;
		System.out.println(fourSum2(nums, target));

	}

	/**
	 * regular method
	 * 
	 * @param nums
	 * @param target
	 * @return
	 */
	public static List<List<Integer>> fourSum(int[] nums, int target) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		Set<List<Integer>> temResult = new HashSet<List<Integer>>();

		if (nums.length < 4) {
			return result;
		}
		Arrays.sort(nums);
		for (int i = 0; i < nums.length - 3; i++) {
			for (int j = i + 1; j < nums.length - 2; j++) {
				for (int k = j + 1; k < nums.length - 1; k++) {
					for (int l = k + 1; l < nums.length; l++) {
						if (nums[i] + nums[j] + nums[k] + nums[l] == target) {
							List<Integer> list = new ArrayList<Integer>();
							list.add(nums[i]);
							list.add(nums[j]);
							list.add(nums[k]);
							list.add(nums[l]);
							temResult.add(list);
						}
					}
				}
			}
		}
		result.addAll(temResult);
		return result;
	}

	/**
	 * two pointer algorithm
	 * @param nums
	 * @param target
	 * @return
	 */
	public static List<List<Integer>> fourSum2(int[] nums, int target) {
		Arrays.sort(nums);
		List<List<Integer>> list = kSum(nums, 0, 4, target);
		return list;
	}

	public static List<List<Integer>> kSum(int[] nums, int start, int k, int target) {
		List<List<Integer>> resultList = new ArrayList<List<Integer>>();
		int len = nums.length;
		// kSum has to have at least k elements
		if (start + k > len) {
			return resultList;
		}
		int kSmallest = 0, kLargest = 0;
		// get the sum of k smallest values and k largest values
		for (int i = 0; i < k; i++) {
			// the smallest value of the sorted array is nums[start]
			kSmallest += nums[start + i];
			// the largest value of the sorted array is nums[nums.lenght-1]
			kLargest += nums[len - 1 - i];
		}
		if (kSmallest > target || kLargest < target) {
			return resultList;
		}
		// when k==2, we can determine the sum.
		if (k == 2) {
			int low = start;
			int high = len - 1;
			while (low < high) {
				int sum = nums[low] + nums[high];
				if (sum > target) {
					high--;
				} else if (sum < target) {
					low++;
				} else {
					List<Integer> tempList = new ArrayList<Integer>();
					tempList.add(nums[low]);
					tempList.add(nums[high]);
					resultList.add(tempList);

					//low < high is used to avoid index out of bound exception
					while (low < high && nums[low] == nums[low + 1]) {
						low++;
					}
					while (low < high && nums[high] == nums[high - 1]) {
						high--;
					}
					low++;
					high--;
				}
			}
			return resultList;
		}

		for (int i = start; i < nums.length; i++) {
			if (i == start || nums[i] != nums[i - 1]) {
				List<List<Integer>> kList = kSum(nums, i + 1, k - 1, target - nums[i]);
				for (List<Integer> list : kList) {
					list.add(nums[i]);
					Collections.sort(list);
					resultList.add(list);
				}
			}
		}
		return resultList;
	}
}
