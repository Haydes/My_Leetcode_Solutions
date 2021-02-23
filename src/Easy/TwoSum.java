package Easy;

/**
 * 1. Two Sum
 * 
 * Given an array of integers, return indices of the two numbers such that they
 * add up to a specific target. You may assume that each input would have
 * exactly one solution, and you may not use the same element twice.
 * 
 * Example:
 * 
 * Given nums = [2, 7, 11, 15], target = 9,
 * 
 * Because nums[0] + nums[1] = 2 + 7 = 9, return [0, 1].
 **/
public class TwoSum {
	public static void main(String[] args) {
		int[] nums = { 1, 2, 3, 4 };
		int target = 6;
		int[] result = twoSum(nums, target);
		System.out.println(result[0] + "" + result[1]);
	}

	public static int[] twoSum(int[] nums, int target) {
		int x = 0, y = 0;
		A: for (int i = 0; i < nums.length; i++) {
			for (int j = i + 1; j < nums.length; j++) {
				if (nums[i] + nums[j] == target) {
					x = i;
					y = j;
					break A;
				}
			}
		}

		int[] indice = { x, y };
		return indice;
	}
}
