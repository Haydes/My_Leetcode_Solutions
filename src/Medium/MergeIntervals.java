package Medium;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * 56. Merge Intervals
 * 
 * Given a collection of intervals, merge all overlapping intervals.
 * 
 * Example:
 * 
 * Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
 * 
 * Output:[[1,6],[8,10],[15,18]]
 */
public class MergeIntervals {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("How many intervals you want to enter:");
		int len = sc.nextInt();
		int[][] intervals = new int[len][2];
		for (int i = 0; i < intervals.length; i++) {
			System.out.println("Interval " + (i + 1) + " low:");
			intervals[i][0] = sc.nextInt();
			System.out.println("Interval " + (i + 1) + " high:");
			intervals[i][1] = sc.nextInt();
		}
		int[][] mergedIntervals = merge(intervals);
		for (int i = 0; i < mergedIntervals.length; i++) {
			System.out.print("[" + mergedIntervals[i][0] + ", " + mergedIntervals[i][1] + "] ");
		}
		sc.close();
	}

	public static int[][] merge(int[][] intervals) {
		Queue<Integer[]> queue = new LinkedList<Integer[]>();
		for (int i = 0; i < intervals.length; i++) {
			// get the current interval
			int low = intervals[i][0];
			int high = intervals[i][1];
			Integer[] interval = new Integer[2];
			int size = queue.size();
			// the loop for queue
			for (int j = 0; j < size; j++) {
				Integer[] preInterval = queue.poll();
				int preLow = preInterval[0];
				int preHigh = preInterval[1];
				if (low > preHigh || high < preLow) {
					queue.add(preInterval);
				} else {
					low = Math.min(low, preLow);
					high = Math.max(high, preHigh);
				}
			}

			interval[0] = low;
			interval[1] = high;
			queue.add(interval);
		}
		int[][] result = new int[queue.size()][2];
		int k = 0;
		while (!queue.isEmpty()) {
			Integer[] poll = queue.poll();
			result[k][0] = poll[0];
			result[k][1] = poll[1];
			k++;
		}
		return result;
	}
}
