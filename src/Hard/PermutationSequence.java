package Hard;

import java.util.LinkedList;
import java.util.List;

/**
 * 60. Permutation Sequence
 * 
 * The set [1, 2, 3, ..., n] contains a total of n! unique permutations.
 * 
 * By listing and labeling all of the permutations in order, we get the
 * following sequence for n = 3:
 * 
 * "123" "132" "213" "231" "312" "321" Given n and k, return the kth permutation
 * sequence.
 *
 * Constraints:
 * 
 * 1 <= n <= 9
 * 
 * 1 <= k <= n!
 */
public class PermutationSequence {
	static int count = 0;

	public static void main(String[] args) {
		String str = getPermutation2(9, 331987);
		System.out.println(str);
	}

	/**
	 * back track, 1218ms, faster than 5.03%
	 * 
	 * @param n
	 * @param k
	 * @return
	 */
	public static String getPermutation(int n, int k) {
		boolean[] used = new boolean[n];
		String backTrack = backTrack("", n, k, used);
		return backTrack;
	}

	public static String backTrack(String str, int n, int k, boolean[] used) {
		if (str.length() == n) {
			count++;
			if (count == k) {
				return str;
			}
			return null;
		}

		for (int i = 1; i <= n; i++) {
			if (used[i - 1]) {
				continue;
			}
			used[i - 1] = true;
			str += i;
			String backTrackStr = backTrack(str, n, k, used);
			if (backTrackStr != null) {
				// 传了值，说明找到了
				return backTrackStr;
			}
			used[i - 1] = false;
			str = str.substring(0, str.length() - 1);
		}

		return null;
	}

	/**
	 * 逐位取数，1 ms, faster than 98.61%
	 * @param n
	 * @param k
	 * @return
	 */
	public static String getPermutation2(int n, int k) {
		List<Integer> numbers = new LinkedList<Integer>();
		int[] factorial = new int[n + 1];
		factorial[0] = 1;
		int num = 1;
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i <= n; i++) {
			num *= i;
			factorial[i] = num;
			numbers.add(i);
		}

		k--;

		for (int i = 1; i <= n; i++) {
			// 第i位数字应该是第numbers.get(index)
			// 例如： n=4 k=14, 那么第一位数字index = 13/factorial[3] = 13/6 = 2
			// 因为除去第一位数字，后三位数字的排列最多有3！= 6种, 第14位就是第3个6种里的(index = 2)
			int index = k / factorial[n - i];
			sb.append(String.valueOf(numbers.get(index)));
			// 在numbers中删除index所属的数字, 因为已经用了
			numbers.remove(index);
			// k此时要变化, 如index=2，已经排除掉前面2*6=12种情况了，k此时变为13-12=1,意思是从剩下的所有组合中找第二个(index = 1)
			k -= index * factorial[n - i];
		}
		return String.valueOf(sb);
	}

}
