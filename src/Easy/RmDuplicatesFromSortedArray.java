package Easy;

/**
 * 26. Remove Duplicates from Sorted Array
 * 
 * Given a sorted array nums, remove the duplicates in-place such that each
 * element appears only once and returns the new length.
 * 
 * Do not allocate extra space for another array, you must do this by modifying
 * the input array in-place with O(1) extra memory.
 *
 * Example 1:
 * 
 * Given nums = [1,1,2],
 * 
 * Your function should return length = 2, with the first two elements of nums
 * being 1 and 2 respectively.
 * 
 * 
 */
public class RmDuplicatesFromSortedArray {
	public static void main(String[] args) {
		int[] nums = { 0, 0, 1, 1, 1, 2, 2, 3, 3, 4 };
		int removeDuplicates = removeDuplicates(nums);
		System.out.println(removeDuplicates);
	}

	
	/**
	 * faster than 100%
	 * @param nums
	 * @return
	 */
	public static int removeDuplicates(int[] nums) {
		int k = 0;
		int i = 0;
		while (k < nums.length) {
			if (k == 0 || (k > 0 && nums[k] != nums[k - 1])) {
				nums[i] = nums[k];
				i++;
			}
			k++;
		}
		return i;
	}
}
