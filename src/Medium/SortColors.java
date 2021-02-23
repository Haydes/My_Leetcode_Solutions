package Medium;

import java.util.Arrays;

/**
 * 75. Sort Colors
 *
 * Given an array nums with n objects colored red, white, or blue, sort them
 * in-place so that objects of the same color are adjacent, with the colors in
 * the order red, white, and blue.
 * 
 * We will use the integers 0, 1, and 2 to represent the color red, white, and
 * blue, respectively.
 * 
 * Could you solve this problem without using the library's sort function?
 * 
 * Could you come up with a one-pass algorithm using only O(1) constant space?
 */
public class SortColors {
	public static void main(String[] args) {
		int[] nums = { 2, 0, 2, 1, 1, 0 };
		sortColors2(nums);
		System.out.println(Arrays.toString(nums));
	}

	/**
	 * 2-pass, 但是不满足上面第二条
	 * 
	 * @param nums
	 */
	public static void sortColors(int[] nums) {
		int[] count = new int[4];
		for (int i = 0; i < nums.length; i++) {
			count[nums[i]] += 1;
		}
		int index = 0;
		for (int i = 0; i < count.length; i++) {
			while (count[i] > 0) {
				nums[index++] = i;
				count[i]--;
			}
		}
	}

	/**
	 * 1-pass, faster than 100.00%
	 * 
	 * @param nums
	 */
	public static void sortColors2(int[] nums) {
		int p1 = 0, p2 = nums.length - 1, index = 0;
		while (index <= p2) {
			// 如果当前为0，则跟p1互换
			if (nums[index] == 0) {
				nums[index] = nums[p1];
				nums[p1] = 0;
				p1++;

			}
			// 如果当前为2, 则跟p2互换
			if (nums[index] == 2) {
				nums[index] = nums[p2];
				nums[p2] = 2;
				p2--;
				// 这个时候可能把后面的换到了index的位置，所以需要重新考虑这个index
				index--;
			}
			// 考虑下一个
			index++;
		}
	}

}
