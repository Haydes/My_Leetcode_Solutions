package Medium;

/**
 * 215. Kth Largest Element in an Array
 * 
 * Find the kth largest element in an unsorted array. Note that it is the kth
 * largest element in the sorted order, not the kth distinct element.
 *
 */
public class KthLargestElementInArray {
	public static void main(String[] args) {
		int[] nums = { 3, 2, 3, 1, 2, 4, 5, 5, 6 };
		int kthLargest = findKthLargest2(nums, 4);
		System.out.println(kthLargest);
	}

	/**
	 * 非常慢
	 * 
	 * @param nums
	 * @param k
	 * @return
	 */
	public static int findKthLargest(int[] nums, int k) {
		for (int i = 0; i < nums.length - 1; i++) {
			for (int j = 0; j < nums.length - 1 - i; j++) {
				if (nums[j] < nums[j + 1]) {
					int temp = nums[j + 1];
					nums[j + 1] = nums[j];
					nums[j] = temp;
				}
			}
		}

		return nums[k - 1];
	}

	/**
	 * use quick sort, faster than 27.27%
	 * 
	 * @param nums
	 * @param k
	 * @return
	 */
	public static int findKthLargest2(int[] nums, int k) {
		int start = 0, end = nums.length - 1;
		// 第k大就是有序数组中index为nums.length - k的元素
		int kth = nums.length - k;
		while (start < end) {
			int pivot = partition(nums, start, end);
			if (pivot < kth) {
				start = pivot + 1;
			} else if (pivot > kth) {
				end = pivot - 1;
			} else {
				return nums[kth];
			}
		}
		return nums[start];
	}

	/**
	 * 
	 * @param nums  数组
	 * @param start 开始索引
	 * @param end   结束索引
	 */
	public static int partition(int[] nums, int start, int end) {
		if (start >= end) {
			return end;
		}
		// 选取最后一个元素作为pivot
		int pivot = nums[end];
		// low从第一个元素开始
		int low = start;
		// high从pivot前一个元素开始
		int high = end - 1;
		while (low < high) {
			// low的元素比pivot大或者low已经到达end的位置即停下
			while (nums[low] <= pivot && low < end) {
				low++;
			}
			// high的元素比pivot小或者high已经到达start的位置即停下
			while (nums[high] >= pivot && high > start) {
				high--;
			}
			// low和high的元素进行交换
			if (low < high) {
				int temp = nums[low];
				nums[low] = nums[high];
				nums[high] = temp;
			}
		}
		if (nums[low] > pivot) {
			// pivot和low的元素进行交换
			nums[end] = nums[low];
			nums[low] = pivot;
		}
		return low;
	}
}
