package Medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 39. Combination Sum Given an array of distinct integers candidates and a
 * target integer target, return a list of all unique combinations of candidates
 * where the chosen numbers sum to target. You may return the combinations in
 * any order.
 * 
 * The same number may be chosen from candidates an unlimited number of times.
 * Two combinations are unique if the frequency of at least one of the chosen
 * numbers is different.
 * 
 * It is guaranteed that the number of unique combinations that sum up to target
 * is less than 150 combinations for the given input.
 *
 */
public class CombinationSum {
	public static void main(String[] args) {
		int[] candidates = { 10, 1, 2, 7, 6, 5 };
		int target = 8;
		List<List<Integer>> combinationSum = combinationSum(candidates, target);
		System.out.println(combinationSum);
	}

	/**
	 * faster than 98.98%
	 * 
	 * @param candidates
	 * @param target
	 * @return
	 */
	public static List<List<Integer>> combinationSum(int[] candidates, int target) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		List<Integer> list = new ArrayList<Integer>();
		Arrays.sort(candidates);
		backtrack(result, list, candidates, target, 0);
		return result;
	}

	public static void backtrack(List<List<Integer>> list, List<Integer> tempList, int[] candidates, int target,
			int start) {
		if (target == 0) {
			list.add(new ArrayList<Integer>(tempList));
			return;
		}
		// target > 0
		for (int i = start; i < candidates.length; i++) {
			if (candidates[i] > target) {
				break;
			}
			tempList.add(candidates[i]);
			// start = i, 所以确保后面的数字只会大于等于前面的
			backtrack(list, tempList, candidates, target - candidates[i], i);
			tempList.remove(tempList.size() - 1);
		}

	}
}
