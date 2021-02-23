package Medium;

/**
 * 34. Find First and Last Position of Element in Sorted Array
 * 
 * Given an array of integers nums sorted in ascending order, find the starting
 * and ending position of a given target value.
 * 
 * If target is not found in the array, return [-1, -1].
 * 
 * Follow up: Could you write an algorithm with O(log n) runtime complexity?
 *
 */
public class FindFirstAndLastPositionOfElementInSortedArray {
	public static void main(String[] args) {
		int[] nums = { 1 };
		int[] searchRange = searchRange(nums, 8);
		for (int i : searchRange) {
			System.out.print(i + " ");
		}
	}

	/**
	 * 
	 * faster than 100%
	 * 
	 * 二分法
	 * 
	 * @param nums
	 * @param target
	 * @return
	 */
	public static int[] searchRange(int[] nums, int target) {
		int[] result = { -1, -1 };

		int high = nums.length - 1;
		int low = 0;

		int max = -1;
		int min = nums.length;

		while (low <= high) {
			int mid = low + (high - low) / 2;
			if (nums[mid] == target) {
				max = mid;
				min = mid;
				int right = mid + 1;
				int left = mid - 1;
				while (left >= 0 && nums[left] == target) {
					min--;
					left--;
				}
				while (right <= nums.length - 1 && nums[right] == target) {
					max++;
					right++;
				}
				break;
			} else if (nums[mid] < target) {
				low = mid + 1;
			} else {
				high = mid - 1;
			}
		}
		if (min < nums.length) {
			result[0] = min;
		}
		result[1] = max;
		return result;
	}

	/**
	 * faster than 13.7%
	 * 
	 * 时间复杂度O(n)
	 * 
	 * @param nums
	 * @param target
	 * @return
	 */
	public static int[] searchRange2(int[] nums, int target) {
		int[] result = { -1, -1 };
		int min = nums.length;
		int max = -1;
		for (int i = 0; i < nums.length; i++) {
			if (target == nums[i]) {
				if (i < min) {
					min = i;
				}
				if (i > max) {
					max = i;
				}
			}
		}

		if (min < nums.length) {
			result[0] = min;
		}
		result[1] = max;
		return result;
	}
}
