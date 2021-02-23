package Medium;

import java.util.ArrayList;
import java.util.List;

/**
 * 78. Subsets
 * 
 * Given an integer array nums, return all possible subsets (the power set).
 * 
 * The solution set must not contain duplicate subsets.
 *
 */
public class Subsets {
	public static void main(String[] args) {
		int[] nums = { 1, 2, 3 };
		List<List<Integer>> subsets = subsets(nums);
		System.out.println(subsets);
	}

	/**
	 * faster than 100%
	 * 
	 * @param nums
	 * @return
	 */
	public static List<List<Integer>> subsets(int[] nums) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		List<Integer> list = new ArrayList<Integer>();
		backtrack(result, list, nums, 0);
		return result;
	}

	public static void backtrack(List<List<Integer>> result, List<Integer> list, int[] nums, int start) {
		result.add(new ArrayList<Integer>(list));

		for (int i = start; i < nums.length; i++) {
			list.add(nums[i]);
			backtrack(result, list, nums, i + 1);
			list.remove(list.size() - 1);
		}
	}

}
