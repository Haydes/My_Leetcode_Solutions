package Medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 90. Subsets II
 * 
 * Given a collection of integers that might contain duplicates, nums, return
 * all possible subsets (the power set).
 * 
 * Note: The solution set must not contain duplicate subsets.
 *
 */
public class SubsetsII {
	public static void main(String[] args) {
		int[] nums = { 1, 2, 2 };
		List<List<Integer>> subsets = subsetsWithDup(nums);
		System.out.println(subsets);
	}

	/**
	 * faster than 99.78%
	 * 
	 * @param nums
	 * @return
	 */
	public static List<List<Integer>> subsetsWithDup(int[] nums) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		Arrays.sort(nums);
		backtrack(result, new ArrayList<Integer>(), nums, 0);

		return result;
	}

	public static void backtrack(List<List<Integer>> result, List<Integer> list, int[] nums, int start) {
		result.add(new ArrayList<Integer>(list));

		for (int i = start; i < nums.length; i++) {
			if (i > start && nums[i] == nums[i - 1]) {
				continue;
			}
			list.add(nums[i]);
			backtrack(result, list, nums, i + 1);
			list.remove(list.size() - 1);
		}
	}
}
