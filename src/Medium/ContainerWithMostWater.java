package Medium;
/**
 * 11. Container With Most Water
 * Given n non-negative integers a1, a2, ..., an , where each represents a point at coordinate (i, ai). 
 * n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0). 
 * Find two lines, which together with x-axis forms a container, such that the container contains the most water.

	Note: You may not slant the container and n is at least 2.
 *
 */
public class ContainerWithMostWater {
	public static void main(String[] args) {
		int[] array = { 1, 8, 6, 2, 5, 4, 8, 3, 7 };
		System.out.println(improveMaxArea(array));
	}

	public static int maxArea(int[] height) {
		int result = 0;
		int start = 0;
		int end = 1;
		for (start = 0; start < height.length - 1; start++) {
			for (end = start + 1; end < height.length; end++) {
				int h = height[start] < height[end] ? height[start] : height[end];
				int w = end - start;
				int tempResult = h * w;
				if (tempResult > result) {
					result = tempResult;
				}
			}
		}

		return result;
	}

	public static int improveMaxArea(int[] height) {
		int result = 0;
		int start = 0;
		int end = height.length - 1;

		while (end > start) {
			int h = (height[start] > height[end]) ? height[end] : height[start];
			int w = end - start;
			result = result > (h * w) ? result : h * w;
			
			if (height[start] > height[end]) {
				end--;
			} else {
				start++;
			}
		}

		return result;
	}
}
