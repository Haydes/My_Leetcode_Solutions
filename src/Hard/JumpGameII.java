package Hard;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 45. Jump Game II
 * 
 * Given an array of non-negative integers nums, you are initially positioned at
 * the first index of the array.
 * 
 * Each element in the array represents your maximum jump length at that
 * position.
 * 
 * Your goal is to reach the last index in the minimum number of jumps.
 * 
 * You can assume that you can always reach the last index.
 *
 */
public class JumpGameII {
	public static void main(String[] args) {
		int[] nums = { 0 };
		int jump = jump3(nums);
		System.out.println(jump);
	}

	/**
	 * 从后面反推, faster than 6.21%
	 * 
	 * @param nums
	 * @return
	 */
	public static int jump(int[] nums) {
		int pos = nums.length - 1;
		int step = 0;
		while (pos > 0) {
			for (int i = 0; i < pos; i++) {
				if (nums[i] >= pos - i) {
					pos = i;
					step++;
					break;
				}
			}
		}
		return step;
	}

	/**
	 * standard BFS, faster than 5.48%
	 * 
	 * @param nums
	 * @return
	 */
	public static int jump2(int[] nums) {
		// 这个数组用于排除重复
		boolean[] visited = new boolean[nums.length];
		Queue<Integer> queue = new LinkedList<Integer>();
		// add the first index
		queue.add(0);
		visited[0] = true;
		int depth = 0;
		while (!queue.isEmpty()) {
			// one time, one level
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				// the position index
				int poll = queue.poll();

				// the position is at the end
				if (poll == nums.length - 1) {
					return depth;
				}
				// max jump length at poll
				int maxInOne = nums[poll];
				for (int j = 1; j <= maxInOne; j++) {
					int nextPos = poll + j;
					if (nextPos > nums.length - 1) {
						break;
					}
					if (visited[nextPos]) {
						continue;
					}

					queue.add(nextPos);
					visited[poll] = true;
				}
			}
			depth++;
		}
		return -1;
	}

	/**
	 * greedy solution of BFS, faster than 100%
	 * 
	 * @param nums
	 * @return
	 */
	public static int jump3(int[] nums) {
		if (nums.length <= 1) {
			return 0;
		}
		int level = 0;
		// 当前能到的最远index,下一步能到的最远index
		int currentMaxIndex = 0, nextMaxIndex = 0;
		// 当前index
		int i = 0;
		
		while (currentMaxIndex - i + 1 > 0) { // nodes count of current level>0
			level++;
			for (; i <= currentMaxIndex; i++) {
				nextMaxIndex = Math.max(nextMaxIndex, nums[i] + i);
				if (nextMaxIndex >= nums.length - 1) {
					return level;
				}
			}
			currentMaxIndex = nextMaxIndex;
		}
		return -1;
	}
}
