package Medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 47. Permutations II
 * 
 * Given a collection of numbers, nums, that might contain duplicates, return
 * all possible unique permutations in any order.
 *
 */
public class PermutationsII {
	public static void main(String[] args) {
		int[] nums = { 1, 1, 2 };
		List<List<Integer>> permuteUnique = permuteUnique(nums);
		System.out.println(permuteUnique);

	}

	/**
	 * faster than 98.75%
	 * 
	 * @param nums
	 * @return
	 */
	public static List<List<Integer>> permuteUnique(int[] nums) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		Arrays.sort(nums);
		boolean[] used = new boolean[nums.length];
		backtrack(nums, result, new ArrayList<Integer>(), 0, used);
		return result;
	}

	public static void backtrack(int[] nums, List<List<Integer>> result, List<Integer> list, int len, boolean[] used) {
		if (len == nums.length) {
			result.add(new ArrayList<Integer>(list));
			return;
		}
		for (int i = 0; i < nums.length; i++) {
			if (used[i] || (i > 0 && nums[i] == nums[i - 1] && !used[i - 1])) {
				continue;
			} else {
				list.add(nums[i]);
				used[i] = true;
				backtrack(nums, result, list, len + 1, used);
				list.remove(list.size() - 1);
				used[i] = false;
			}
		}
	}
}
