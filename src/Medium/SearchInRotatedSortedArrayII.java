package Medium;

/**
 * 81. Search in Rotated Sorted Array II
 * 
 * There is an integer array nums sorted in non-decreasing order (not
 * necessarily with distinct values).
 * 
 * Before being passed to your function, nums is rotated at an unknown pivot
 * index k (0 <= k < nums.length) such that the resulting array is [nums[k],
 * nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]] (0-indexed). For
 * example, [0,1,2,4,4,4,5,6,6,7] might be rotated at pivot index 5 and become
 * [4,5,6,6,7,0,1,2,4,4].
 * 
 * Given the array nums after the rotation and an integer target, return true if
 * target is in nums, or false if it is not in nums.
 *
 */
public class SearchInRotatedSortedArrayII {
	public static void main(String[] args) {
		int[] nums = { 5, 6, 7, 1, 1, 1, 1 };
		int target = 6;
		System.out.println(search(nums, target));
	}

	/**
	 * 二分法, faster than 100.00% 
	 * @param nums
	 * @param target
	 * @return
	 */
	public static boolean search(int[] nums, int target) {
		int high = nums.length - 1;
		int low = 0;
		while (low <= high) {
			int mid = low + (high - low) / 2;
			// 找到目标
			if (target == nums[mid]) {
				return true;
			}
            
			if (nums[low] > nums[mid]) { //左半边无序，右半边有序
				if (target > nums[mid] && target <= nums[high]) {
					low = mid + 1;
				} else {
					high = mid - 1;
				}
			} else if (nums[low] < nums[mid]) {// 左半边有序
				if (target >= nums[low] && target < nums[mid]) {
					high = mid - 1;
				} else {
					low = mid + 1;
				}
			} else {
				// 无法确定，但是知道nums[mid]==nums[low]
				low++;
			}
		}
		return false;
	}
}
