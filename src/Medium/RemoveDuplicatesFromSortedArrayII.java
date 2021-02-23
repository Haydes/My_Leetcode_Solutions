package Medium;

import java.util.Arrays;

import utils.MyPrinter;

/**
 * 80. Remove Duplicates from Sorted Array II
 * 
 * Given a sorted array nums, remove the duplicates in-place such that
 * duplicates appeared at most twice and return the new length.
 * 
 * Do not allocate extra space for another array; you must do this by modifying
 * the input array in-place with O(1) extra memory.
 * 
 * Clarification:
 * 
 * Confused why the returned value is an integer, but your answer is an array?
 * 
 * Note that the input array is passed in by reference, which means a
 * modification to the input array will be known to the caller.
 *
 */
public class RemoveDuplicatesFromSortedArrayII {
	public static void main(String[] args) {
		int[] nums = { 1, 1, 1, 2, 2, 3 };
		MyPrinter.printFirstNthElementOfArray(nums, removeDuplicates(nums));
	}

	/**
	 * 1 ms, faster than 33.68%
	 * 
	 * @param nums
	 * @return
	 */
	public static int removeDuplicates(int[] nums) {
		int times = 1;
		int number = nums[0];
		// 用i遍历整个数组
		int i = 1;
		// 用currentIndex保存当前要放置的位置
		int currentIndex = 1;
		while (i < nums.length) {
			if (nums[i] == number) {
				times++;
				// 如果重复了超过2次
				if (times > 2) {
					times--;
					i++;
				} else {
					nums[currentIndex++] = nums[i++];
				}
			} else {
				nums[currentIndex++] = nums[i];
				number = nums[i++];
				times = 1;
			}
		}
		return currentIndex;
	}

	/**
	 * 可以换成最多k个重复的数组, 0 ms, faster than 100.00%
	 * 
	 * @param nums
	 * @return
	 */
	public static int removeDuplicates2(int[] nums) {
		int index = 0;
		for (int num : nums) {
			// 只要是前2个元素，或者说当前遍历到的元素比它对应要放置位置前2个的位置的元素大，就放过去
			if (index < 2 || num > nums[index - 2]) {
				nums[index++] = num;
			}
		}
		return index;
	}
}
