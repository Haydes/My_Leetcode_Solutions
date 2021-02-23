package Medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 57. Insert Interval
 * 
 * Given a set of non-overlapping intervals, insert a new interval into the
 * intervals (merge if necessary).
 * 
 * You may assume that the intervals were initially sorted according to their
 * start times.
 * 
 * 
 * Constraints:
 * 
 * 0 <= intervals.length <= 104
 * 
 * intervals[i].length == 2
 * 
 * 0 <= intervals[i][0] <= intervals[i][1] <= 105
 * 
 * intervals is sorted by intervals[i][0] in ascending order.
 * 
 * newInterval.length == 2
 * 
 * 0 <= newInterval[0] <= newInterval[1] <= 105
 * 
 * Example:
 * 
 * Input: intervals = [[1,3],[6,9]], newInterval = [2,5]
 * 
 * Output: [[1,5],[6,9]]
 *
 */
public class InsertInterval {
	public static void main(String[] args) {
		int[][] intervals = { { 1, 3 }, { 6, 9 } };
		int[] newInterval = { 2, 5 };
		int[][] insert = insert2(intervals, newInterval);
		for (int[] is : insert) {
			System.out.println("[" + is[0] + "," + is[1] + "]");
		}
	}

	/**
	 * 先添加进队列，再merge, faster than 19.48%
	 * 
	 * @param intervals
	 * @param newInterval
	 * @return
	 */
	public static int[][] insert(int[][] intervals, int[] newInterval) {
		Queue<Integer[]> queue = new LinkedList<Integer[]>();
		Integer[] newIn = { newInterval[0], newInterval[1] };
		queue.add(newIn);
		for (int i = 0; i < intervals.length; i++) {
			// get the current interval
			Integer[] interval = { intervals[i][0], intervals[i][1] };
			int size = queue.size();
			for (int j = 0; j < size; j++) {
				Integer[] poll = queue.poll();
				if (interval[0] > poll[1] || interval[1] < poll[0]) {
					queue.add(poll);
				} else {
					interval[0] = Math.min(interval[0], poll[0]);
					interval[1] = Math.max(interval[1], poll[1]);
				}
			}
			queue.add(interval);
		}

		int[][] result = new int[queue.size()][2];
		int j = 0;
		for (Integer[] interval : queue) {
			result[j][0] = interval[0];
			result[j][1] = interval[1];
			j++;
		}
		for (int i = 0; i < result.length - 1; i++) {
			for (int k = i; k < result.length - 1; k++) {
				if (result[k][0] > result[k + 1][0]) {
					int[] temp = result[k];
					result[k] = result[k + 1];
					result[k + 1] = temp;

				}
			}
		}
		return result;
	}

	/**
	 * 边判断边添加, faster than 98.73%
	 * 
	 * @param intervals
	 * @param newInterval
	 * @return
	 */
	public static int[][] insert2(int[][] intervals, int[] newInterval) {
		int start = newInterval[0];
        int end = newInterval[1];
        List<int[]> result = new ArrayList<int[]>();
		boolean added = false;
		for (int i = 0; i < intervals.length; i++) {
			if (intervals[i][1] < newInterval[0]) {
				// 新区间的最小值比当前区间最大值大
				result.add(intervals[i]);
			} else if (intervals[i][0] > newInterval[1]) {
				// 新区间的最大值比当前区间最小值小
				// 先添加新区间，只添加一次
				if (!added) {
					result.add(new int[]{start, end});
					added = true;
				}
				result.add(intervals[i]);
			} else {
				// 当前区间和新区间有交集
				start = Math.min(start, intervals[i][0]);
				end = Math.max(end, intervals[i][1]);
			}
		}
		// 新区间比所有区间都大
		if (!added) {
			result.add(new int[]{start, end});
		}
		return result.toArray(new int[result.size()][2]);
	}

}
