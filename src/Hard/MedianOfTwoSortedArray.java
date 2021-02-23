package Hard;

/**
 * 
 * 4. Median of Two Sorted Arrays
 * Given two sorted arrays nums1 and nums2 of size m and n respectively, 
 * return the median of the two sorted arrays.
 *
 */
public class MedianOfTwoSortedArray {
	public static void main(String[] args) {
		int[] nums1 = {1};
		int[] nums2 = {1};
		double result = 0;

//		result = myFindMedianSolution(nums1, nums2);
//		result = findMedianSortedArrays(nums1, nums2);
		result = mySolutionImprove(nums1, nums2);
		System.out.println(result);
	}

	public static double myFindMedianSolution(int[] nums1, int[] nums2) {
		double result;
		int[] sum = new int[nums1.length + nums2.length];
		for (int i = 0; i < sum.length; i++) {
			if (i < nums1.length) {
				sum[i] = nums1[i];
			} else {
				sum[i] = nums2[i - nums1.length];
			}
		}
		for (int i = 0; i < sum.length - 1; i++) {
			for (int j = 1; j < sum.length - i; j++) {
				int temp = 0;
				if (sum[j - 1] > sum[j]) {
					temp = sum[j];
					sum[j] = sum[j - 1];
					sum[j - 1] = temp;
				}
			}
		}
		if (sum.length % 2 == 1) {
			result = sum[sum.length / 2];
		} else {
			int twoNum = sum[sum.length / 2] + sum[sum.length / 2 - 1];
			result = (double) twoNum / 2;
		}
		return result;
	}

	public static double findMedianSortedArrays(int[] A, int[] B) {
		int m = A.length;
		int n = B.length;
		if (m > n) { // to ensure m<=n
			int[] temp = A;
			A = B;
			B = temp;
			int tmp = m;
			m = n;
			n = tmp;
		}
		int iMin = 0, iMax = m, halfLen = (m + n + 1) / 2;
		while (iMin <= iMax) {
			int i = (iMin + iMax) / 2;
			int j = halfLen - i;
			if (i < iMax && B[j - 1] > A[i]) {
				iMin = i + 1; // i is too small
			} else if (i > iMin && A[i - 1] > B[j]) {
				iMax = i - 1; // i is too big
			} else { // i is perfect
				int maxLeft = 0;
				if (i == 0) {
					maxLeft = B[j - 1];
				} else if (j == 0) {
					maxLeft = A[i - 1];
				} else {
					maxLeft = Math.max(A[i - 1], B[j - 1]);
				}
				if ((m + n) % 2 == 1) {
					return maxLeft;
				}

				int minRight = 0;
				if (i == m) {
					minRight = B[j];
				} else if (j == n) {
					minRight = A[i];
				} else {
					minRight = Math.min(B[j], A[i]);
				}

				return (maxLeft + minRight) / 2.0;
			}
		}
		return 0.0;
	}

	public static double mySolutionImprove(int[] nums1, int[] nums2) {
		double result = 0;
		int[] merge = new int[nums1.length + nums2.length];
		int j = 0, k = 0;

		for (int i = 0; i < merge.length; i++) {
			if (j >= nums1.length) {
				merge[i] = nums2[k];
				k++;
			} else if (k >= nums2.length) {
				merge[i] = nums1[j];
				j++;
			} else if (nums1[j] < nums2[k]) {
				merge[i] = nums1[j];
				j++;
			} else {
				merge[i] = nums2[k];
				k++;
			}
		}
		
		if (merge.length % 2 == 1) {
			result = merge[merge.length / 2];
		} else {
			int twoNum = merge[merge.length / 2] + merge[merge.length / 2 - 1];
			result = (double) twoNum / 2;
		}

		return result;
	}
}
