package Medium;

import java.util.ArrayList;
import java.util.List;

/**
 * 77. Combinations
 * 
 * Given two integers n and k, return all possible combinations of k numbers out
 * of 1 ... n.
 * 
 * You may return the answer in any order.
 * 
 */
public class Combinations {
	public static void main(String[] args) {
		List<List<Integer>> combine = combine(4, 3);
		System.out.println(combine);
	}

	/**
	 * faster than 92.6%
	 * @param n
	 * @param k
	 * @return
	 */
	public static List<List<Integer>> combine(int n, int k) {
		int[] nums = new int[n];
		for (int i = 0; i < n; i++) {
			nums[i] = i + 1;
		}
		List<Integer> list = new ArrayList<Integer>();
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		DFS(nums, 0, n, k, list, result);
		return result;
	}

	public static void DFS(int[] nums, int start, int end, int k, List<Integer> list, List<List<Integer>> result) {
		if (k == 0) {
			result.add(list);
			return;
		}
		for (int i = start; i < end - k + 1; i++) {
			//use another list, so we will not change the current list
			List<Integer> temp = new ArrayList<Integer>();
			temp.addAll(list);
			temp.add(nums[i]);
			DFS(nums, i + 1, end, k - 1, temp, result);
		}
	}
}
