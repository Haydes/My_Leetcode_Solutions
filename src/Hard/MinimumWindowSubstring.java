package Hard;

import java.util.HashMap;
import java.util.Map;

/**
 * 76. Minimum Window Substring
 * 
 * Given two strings s and t, return the minimum window in s which will contain
 * all the characters in t. If there is no such window in s that covers all
 * characters in t, return the empty string "".
 * 
 * Note that If there is such a window, it is guaranteed that there will always
 * be only one unique minimum window in s.
 *
 */
public class MinimumWindowSubstring {
	public static void main(String[] args) {
		System.out.println(minWindow("KADOBECODEBANC", "ABC"));
	}

	/**
	 * 滑动窗口，12 ms, faster than 53.56% 
	 * @param s
	 * @param t
	 * @return
	 */
	public static String minWindow(String s, String t) {
		if (s == null || s.length() == 0 || s.length() < t.length()) {
			return "";
		}

		// 用一个map记录所有字符的数量
		Map<Character, Integer> countMap = new HashMap<Character, Integer>();
		for (char ch : t.toCharArray()) {
			countMap.put(ch, countMap.getOrDefault(ch, 0) + 1);
		}

		// 用于统计已匹配字符数
		int matched = 0;
		// 左右指针
		int left = 0, right = 0;
		// 最小子串长度
		int min = s.length() + 1;
		// 最小子串起点索引
		int start = 0;
		while (right < s.length()) {
			char ch = s.charAt(right);
			// 如果该字符能匹配t字符串中某个字符
			if (countMap.containsKey(ch)) {
				// 对应map中计数减一
				countMap.put(ch, countMap.get(ch) - 1);
				// ch是匹配项而不是多余匹配，如AA匹配A，一个匹配，另一个多余了，但也匹配
				if (countMap.get(ch) >= 0) {
					matched++;
				}

				// 如果匹配数与t串长度相等，则完全匹配
				while (matched == t.length()) {
					// 此时的长度
					int len = right - left + 1;
					if (len < min) {
						min = len;
						start = left;
					}
					char firstChar = s.charAt(left);
					// 如果子串第一个字符在map中
					if (countMap.containsKey(firstChar)) {
						// 将其加一,因为下一步将要把left右移，firstChar不会再在子串中
						countMap.put(firstChar, countMap.get(firstChar) + 1);
						// 如果对应数量因为加一后大于0，则表示不再能够完全匹配, matched减1
						if (countMap.get(firstChar) > 0) {
							matched--;
						}
					}
					// left右移一位
					left++;
				}
			}
			right++;
		}
		return min > s.length() ? "" : s.substring(start, start + min);
	}

}
