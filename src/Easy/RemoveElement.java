package Easy;

/**
 * 27. Remove Element
 * 
 * Given an array nums and a value val, remove all instances of that value
 * in-place and return the new length.
 * 
 * Do not allocate extra space for another array, you must do this by modifying
 * the input array in-place with O(1) extra memory.
 * 
 * The order of elements can be changed. It doesn't matter what you leave beyond
 * the new length.
 *
 */
public class RemoveElement {
	public static void main(String[] args) {
		int[] nums = {3, 2, 2, 3};
		int len = removeElement(nums, 3);
		System.out.println(len);
	}

	/**
	 * faster than 100%
	 * @param nums
	 * @param val
	 * @return
	 */
	public static int removeElement(int[] nums, int val) {
		int index = 0;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] != val) {
				nums[index++] = nums[i];
			}
		}
		return index;
	}
}
