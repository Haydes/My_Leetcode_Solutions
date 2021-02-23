package Hard;

/**
 * 42. Trapping Rain Water
 *
 * Given n non-negative integers representing an elevation map where the width
 * of each bar is 1, compute how much water it can trap after raining.
 */
public class TrappingRainWater {
	public static void main(String[] args) {
		int[] height = { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 };
		int trap = trap3(height);
		System.out.println(trap);
	}

	/**
	 * 暴力法
	 * 
	 * faster than 6.27%
	 * 
	 * @param height
	 * @return
	 */
	public static int trap(int[] height) {
		int ans = 0;

		for (int i = 0; i < height.length; i++) {
			int left_max = 0, right_max = 0;
			for (int j = i; j >= 0; j--) {
				left_max = Math.max(left_max, height[j]);
			}
			for (int j = i; j < height.length; j++) {
				right_max = Math.max(right_max, height[j]);
			}
			ans += (Math.min(left_max, right_max) - height[i]);
		}

		return ans;
	}

	/**
	 * dynamic programming, faster than 85.05%
	 * 
	 * @param height
	 * @return
	 */
	public static int trap2(int[] height) {
		int ans = 0;

		int left = 0, right = 0;
		int[] left_max = new int[height.length];
		int[] right_max = new int[height.length];
		for (int i = 0; i < height.length; i++) {
			left = Math.max(left, height[i]);
			left_max[i] = left;
		}

		for (int i = height.length - 1; i >= 0; i--) {
			right = Math.max(right, height[i]);
			right_max[i] = right;
		}
		for (int i = 0; i < height.length; i++) {
			ans += (Math.min(left_max[i], right_max[i]) - height[i]);
		}

		return ans;
	}

	/**
	 * two pointers, faster than 100%
	 * 
	 * @param height
	 * @return
	 */
	public static int trap3(int[] height) {
		int ans = 0;
		int left_max = 0, right_max = 0;
		int left = 0, right = height.length - 1;
		while (left < right) {
			if (height[left] < height[right]) {
				if (height[left] >= left_max) {
					left_max = height[left];
				} else {
					ans += (left_max - height[left]);
				}
				left++;
			} else {
				if (height[right] >= right_max) {
					right_max = height[right];
				} else {
					ans += (right_max - height[right]);
				}
				right--;
			}
		}
		return ans;
	}
}
