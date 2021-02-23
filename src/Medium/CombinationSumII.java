package Medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 40. Combination Sum II
 *
 * Given a collection of candidate numbers (candidates) and a target number
 * (target), find all unique combinations in candidates where the candidate
 * numbers sum to target.
 * 
 * Each number in candidates may only be used once in the combination.
 * 
 * Note: The solution set must not contain duplicate combinations.
 */
public class CombinationSumII {
	public static void main(String[] args) {
		int[] candidates = { 10, 1, 2, 7, 6, 1, 5 };
		int target = 8;
		List<List<Integer>> combinationSum = combinationSum2(candidates, target);
		System.out.println(combinationSum);
	}

	/**
	 * faster than 98.74%
	 * 
	 * @param candidates
	 * @param target
	 * @return
	 */
	public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		Arrays.sort(candidates);
		backtrack(result, new ArrayList<Integer>(), target, 0, candidates);
		return result;
	}

	public static void backtrack(List<List<Integer>> result, List<Integer> list, int target, int start,
			int[] candidates) {
		if (target == 0) {
			result.add(new ArrayList<Integer>(list));
			return;
		}
		for (int i = start; i < candidates.length; i++) {
			if (i > start && candidates[i] == candidates[i - 1]) {
				continue;
			}
			// 目标比下一个数小，不需要继续
			if (target < candidates[i]) {
				break;
			}
			list.add(candidates[i]);
			backtrack(result, list, target - candidates[i], i + 1, candidates);
			list.remove(list.size() - 1);
		}
	}
}
