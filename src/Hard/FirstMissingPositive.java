package Hard;

/**
 * 41. First Missing Positive
 * 
 * Given an unsorted integer array nums, find the smallest missing positive
 * integer.
 * 
 * Follow up: Could you implement an algorithm that runs in O(n) time and uses
 * constant extra space.?
 *
 */
public class FirstMissingPositive {
	public static void main(String[] args) {
		int[] nums = { 3, 4, -1, 1 };
		int firstMissingPositive = firstMissingPositive(nums);
		System.out.println(firstMissingPositive);
	}

	/**
	 * 1. 忽略所有比数组长度len大的数字， 忽略所有比1小的数字
	 * 
	 * 2. 思路是把1放在nums[0], 2放在nums[1]。。。把nums[n]放在nums[nums[n]-1]中
	 * 
	 * 3. 最后判断nums[n] == n+1?
	 * 
	 * faster than 100%
	 * 
	 * @param nums
	 * @return
	 */
	public static int firstMissingPositive(int[] nums) {
		int n = nums.length;
		for (int i = 0; i < n; ++i) {
			// nums[nums[i] - 1] 是
			// nums[i]应该在的位置，假如它跟原本的nums[i]不同，则交换，所以nums[i]的值会被放在nums[nums[i]-1]处
			// 例如nums[2] = 1, nums[nums[2]-1] = nums[0] != nums[2],所以交换， 交换后nums[0]=1
			while (nums[i] > 0 && nums[i] <= n && nums[nums[i] - 1] != nums[i]) {
				int temp = nums[nums[i] - 1];
				nums[nums[i] - 1] = nums[i];
				nums[i] = temp;
			}
		}
		for (int i = 0; i < n; ++i) {
			if (nums[i] != i + 1)
				return i + 1;
		}
		return n + 1;
	}
}
