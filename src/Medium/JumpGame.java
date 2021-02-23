package Medium;

/**
 * 55. Jump Game
 * 
 * Given an array of non-negative integers nums, you are initially positioned at
 * the first index of the array.
 * 
 * Each element in the array represents your maximum jump length at that
 * position.
 * 
 * Determine if you are able to reach the last index.
 *
 */
public class JumpGame {
	public static void main(String[] args) {
		int[] nums = { 1, 0, 0, 0 };
		System.out.println(canJump2(nums) ? "Yes, can jump!" : "No, can't jump!");

	}

	/**
	 * faster than 18.45%
	 * 
	 * @param nums
	 * @return
	 */
	public static boolean canJump(int[] nums) {
		if (nums.length < 2)
			return true;
		int pos = nums.length - 1;
		int prePost = pos;
		int i = 0;
		while (pos > 0 && i != prePost) {
			prePost = pos;
			for (i = 0; i < pos; i++) {
				if (nums[i] >= pos - i) {
					pos = i;
					break;
				}
			}
		}
		if (i == prePost) {
			return false;
		}
		return true;
	}

	/**
	 * faster than 36.17%
	 * 
	 * @param nums
	 * @return
	 */
	public static boolean canJump2(int[] nums) {
		if (nums.length < 2) {
			return true;
		}

		// 定义一个当前位置最远能到达的位置
		int currentMaxIndex = 0;
		// 定义一个下一步最远能到达的位置
		int nextMaxIndex = 0;
		// 定义当前位置
		int i = 0;

		// 最远能到达的位置必须大于等于当前位置
		while (currentMaxIndex - i >= 0) {
			// 当前在i位置
			// 下一步可以走到i到currentMaxIndex之间的任意位置
			// 所以需要在这些位置中找出来哪一个位置可以走到下一步最远能到达位置
			for (; i <= currentMaxIndex; i++) {
				// 下一步最远能到达位置可能是当前位置加上它的步数
				nextMaxIndex = Math.max(nextMaxIndex, i + nums[i]);
				// 如果下一步最远能到达位置是最后一个元素或以上，说明能到终点
				if (nextMaxIndex >= nums.length - 1) {
					return true;
				}
			}
			currentMaxIndex = nextMaxIndex;
		}
		// 遍历完都到不了终点
		return false;
	}

	/**
	 * 遍历数组查看每一步能到的最远位置，faster than 85.54%
	 * 
	 * @param nums
	 * @return
	 */
	public static boolean canJump3(int[] nums) {
		if (nums.length < 2) {
			return true;
		}
		int maxReachableIndex = 0;
		int currentIndex = 0;
		while (currentIndex <= maxReachableIndex) {
			maxReachableIndex = Math.max(maxReachableIndex, nums[currentIndex] + currentIndex);
			if (maxReachableIndex >= nums.length - 1) {
				return true;
			}
			currentIndex++;
		}
		return false;
	}

}
