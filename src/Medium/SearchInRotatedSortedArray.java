package Medium;

/**
 * 33. Search in Rotated Sorted Array
 * 
 * You are given an integer array nums sorted in ascending order, and an integer
 * target.
 * 
 * Suppose that nums is rotated at some pivot unknown to you beforehand (i.e.,
 * [0,1,2,4,5,6,7] might become [4,5,6,7,0,1,2]).
 * 
 * If target is found in the array return its index, otherwise, return -1.
 *
 */
public class SearchInRotatedSortedArray {
	public static void main(String[] args) {
		int[] nums = { 4, 5, 6, 7, 0, 1, 2, 3 };
		int search = search(nums, 3);
		System.out.println(search);
	}

	/**
	 * faster than 100.00%
	 * 
	 * @param nums
	 * @param target
	 * @return
	 */
	public static int search(int[] nums, int target) {
		int high = nums.length - 1;
		int low = 0;
		while (low <= high) {
			// 这个要记住
			int mid = low + (high - low) / 2;
			if (target == nums[mid]) {
				return mid;
			}
			// mid右边是有序的
			if (nums[high] > nums[mid]) {
				if (target > nums[mid] && target <= nums[high]) {
					low = mid + 1;
				} else {
					high = mid - 1;
				}
			} else { // mid左边是有序的
				if (target < nums[mid] && target >= nums[low]) {
					high = mid - 1;
				} else {
					low = mid + 1;
				}
			}
		}
		return -1;
	}
}
