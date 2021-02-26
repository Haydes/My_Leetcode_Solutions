package Easy;

import java.util.Arrays;

/**
 * 88. Merge Sorted Array
 * 
 * Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as
 * one sorted array.
 * 
 * The number of elements initialized in nums1 and nums2 are m and n
 * respectively. You may assume that nums1 has a size equal to m + n such that
 * it has enough space to hold additional elements from nums2.
 *
 */
public class MergeSortedArray {
	public static void main(String[] args) {
		int[] nums1 = { 1, 2, 3, 0, 0, 0 };
		int m = 3;
		int[] nums2 = { 2, 5, 6 };
		int n = 3;
		merge(nums1, m, nums2, n);
		System.out.println(Arrays.toString(nums1));
	}

	/**
	 * 0 ms, faster than 100.00%
	 * 
	 * @param nums1
	 * @param m
	 * @param nums2
	 * @param n
	 */
	public static void merge(int[] nums1, int m, int[] nums2, int n) {
		int index = m + n - 1;
		m--;
		n--;
		while (m >= 0 && n >= 0) {
			if (nums1[m] > nums2[n]) {
				nums1[index--] = nums1[m--];
			} else {
				nums1[index--] = nums2[n--];
			}
		}
		// 只用保证n剩余项写入,因为如果m有剩余，那么代表n无剩余，nums2已经全部插入，nums1剩余部分小于nums2，本身就在数组里
		while (n >= 0) {
			nums1[index--] = nums2[n--];
		}
	}
}
