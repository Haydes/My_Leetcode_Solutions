package Easy;

/**
 * 28. Implement strStr()
 * 
 * Implement strStr().
 * 
 * Return the index of the first occurrence of needle in haystack, or -1 if
 * needle is not part of haystack.
 * 
 * Clarification:
 * 
 * What should we return when needle is an empty string? This is a great
 * question to ask during an interview.
 * 
 * For the purpose of this problem, we will return 0 when needle is an empty
 * string. This is consistent to C's strstr() and Java's indexOf().
 *
 */
public class ImplementStrStr {
	public static void main(String[] args) {
		String haystack = "aabcaaabcdyaaabcdaaa";
		String needle = "aaabcdaaa";
		int index = strStrKMP(haystack, needle);
		System.out.println(index);
	}

	/**
	 * faster than 63.4%
	 * 
	 * @param haystack
	 * @param needle
	 * @return
	 */
	public static int strStr(String haystack, String needle) {
		int hLen = haystack.length();
		int nLen = needle.length();
		if (nLen == 0) {
			return 0;
		} else if (hLen < nLen) {
			return -1;
		}

		int index = -1;
		for (int i = 0; i <= hLen - nLen; i++) {
			if (haystack.charAt(i) == needle.charAt(0)) {
				index = i;
				boolean holds = true;
				for (int j = 1; j < nLen; j++) {
					if (haystack.charAt(i + j) != needle.charAt(j)) {
						index = -1;
						holds = false;
						break;
					}
				}
				if (holds) {
					return index;
				}
			}
		}
		return index;
	}

	/**
	 * faster than 49.39%
	 * 
	 * @param haystack
	 * @param needle
	 * @return
	 */
	public static int strStr2(String haystack, String needle) {
		int hLen = haystack.length();
		int nLen = needle.length();
		if (nLen == 0) {
			return 0;
		} else if (hLen < nLen) {
			return -1;
		}

		int i = 0, j = 0;
		while (i < hLen) {
			if (haystack.charAt(i) == needle.charAt(j)) {
				i++;
				j++;
			} else {
				i = i - j + 1;
				j = 0;
			}
			if (j == nLen) {
				return i - j;
			}
		}
		return -1;
	}

	/**
	 * use KMP algorithm 
	 * 
	 * faster than 22.42%
	 * 
	 * @param haystack
	 * @param needle
	 * @return
	 */
	public static int strStrKMP(String haystack, String needle) {
		int hLen = haystack.length();
		int nLen = needle.length();
		if (nLen == 0) {
			return 0;
		} else if (hLen < nLen) {
			return -1;
		}

		int[] prefix = makePrefixTable(needle);

		int i = 0, j = 0;
		while (i < hLen && j < nLen) {
			if (haystack.charAt(i) == needle.charAt(j)) {
				i++;
				j++;
			} else {
				// 当前字符不匹配
				if (j > 0) {
					// j>0 已经匹配成功了j个字符，查看第j个字符所对应的prefix：prefix[j-1]
					// 例如: j = 5, prefix[4] = 2, 则从0到4的长度为5的子串中，有最长为2的前缀跟后缀相同
					// 所以我们可以直接从j=2, 也就是第三位开始比较，因为前两位0，1跟已比较的3，4是相同的
					j = prefix[j - 1];
				} else {
					// j=0 一个字符都没匹配成功, 直接看下一个字符
					i++;
				}
			}
			if (j == nLen) {
				return i - j;
			}
		}
		return -1;
	}

	/**
	 * 前缀后缀表
	 * 
	 * @param needle
	 * @return
	 */
	public static int[] makePrefixTable(String needle) {
		int len = 0;
		int i = 1;
		int[] prefix = new int[needle.length()];
		prefix[0] = 0;

		while (i < needle.length()) {
			if (needle.charAt(i) == needle.charAt(len)) {
				len++;
				prefix[i] = len;
				i++;
			} else {
				if (len > 0) {
					len = prefix[len - 1];
				} else {
					prefix[i] = 0;
					i++;
				}
			}
		}

		return prefix;
	}
}
