package Easy;

/**
 * 35. Search Insert Position
 * 
 * Given a sorted array of distinct integers and a target value, return the
 * index if the target is found. If not, return the index where it would be if
 * it were inserted in order.
 *
 */
public class SearchInsertPosition {
	public static void main(String[] args) {
		int[] nums = { 1, 3, 5, 6 };
		int searchInsert = searchInsert(nums, 0);
		System.out.println(searchInsert);
	}

	/**
	 * faster than 100%
	 * 
	 * 二分法
	 * 
	 * @param nums
	 * @param target
	 * @return
	 */
	public static int searchInsert(int[] nums, int target) {
		int high = nums.length - 1;
		int low = 0;
		while (low <= high) {
			int mid = low + (high - low) / 2;
			if (nums[mid] == target) {
				return mid;
			}

			if (nums[mid] > target) {
				high = mid - 1;
			} else {
				low = mid + 1;
			}
		}

		// 到这里就是没找到，所以要插入low的位置
		return low;
	}
}
