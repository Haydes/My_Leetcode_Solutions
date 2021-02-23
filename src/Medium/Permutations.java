package Medium;

import java.util.ArrayList;
import java.util.List;

/**
 * 46. Permutations
 * 
 * Given an array nums of distinct integers, return all the possible
 * permutations. You can return the answer in any order.
 *
 */
public class Permutations {
	public static void main(String[] args) {
		int[] nums = { 1, 2, 3 };
		List<List<Integer>> permute = permute(nums);
		System.out.println(permute);
	}

	/**
	 * faster than 45.03%
	 * 
	 * @param nums
	 * @return
	 */
	public static List<List<Integer>> permute(int[] nums) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		List<Integer> list = new ArrayList<Integer>();
		permutation(nums, list, result);
		return result;
	}

	public static void permutation(int[] nums, List<Integer> list, List<List<Integer>> result) {
		if (list.size() == nums.length) {
			// 这里如果不用新的list会导致result内部随着list的变化而变化
			result.add(new ArrayList<Integer>(list));
			return;
		}
		for (int i = 0; i < nums.length; i++) {
			if (list.contains(nums[i])) {
				continue;
			} else {
				list.add(nums[i]);
				permutation(nums, list, result);
				list.remove(list.size() - 1);
			}
		}
	}
}
