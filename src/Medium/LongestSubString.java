package Medium;

import java.util.HashMap;

/**
 * 3. Longest Substring Without Repeating Characters
 * 
 * Given a string, find the length of the longest substring without repeating characters.
 */

import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class LongestSubString {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String str = scan.next();
		int len = lengthOfLongestSubstring3(str);
		System.out.println(len);
		scan.close();
	}

	public static int lengthOfLongestSubstring(String s) {
		Set<Character> characters = new HashSet<Character>();
		int max = 0;
		int count = 0;
		String subString = "";
		for (int i = 0; i < s.length(); i++) {
			if (s.length() - i <= max) {
				break;
			}
			characters.clear();
			count = 0;
			for (int j = i; j < s.length(); j++) {
				if (characters.contains(s.charAt(j))) {
					break;
				} else {
					characters.add(s.charAt(j));
					count++;
					if (max < count) {
						max = count;
						subString = s.substring(i, j + 1);
					}
				}
			}
		}
		return max;
	}

	/**
	 * Sliding Window
	 * 
	 * @param s
	 * @return
	 */
	public static int lengthOfLongestSubstring2(String s) {
		int n = s.length();
		Set<Character> set = new HashSet<>();
		int ans = 0, i = 0, j = 0;
		while (i < n && j < n) {
			// try to extend the range [i, j]
			if (!set.contains(s.charAt(j))) {
				set.add(s.charAt(j++));
				ans = Math.max(ans, j - i);
			} else {
				set.remove(s.charAt(i++));
			}
		}
		return ans;
	}

	/**
	 * Sliding Window Optimal
	 * 
	 * faster than 86.6%
	 * 
	 * @param s
	 * @return
	 */
	public static int lengthOfLongestSubstring3(String s) {
		int n = s.length();
		int max = 0;
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		// i表示前面 j表示后面
		int i = 0, j = 0;
		while (j < n) {
			// 如果map里面存在当前字符，则直接将其实字符改为map中记录的当前字符index+1
			if (map.containsKey(s.charAt(j))) {
				i = Math.max(i, map.get(s.charAt(j)) + 1);
			}
			max = Math.max(max, j - i + 1);
			// 把当前字符的index记录下来
			map.put(s.charAt(j), j);
			j++;
		}
		return max;
	}
}
