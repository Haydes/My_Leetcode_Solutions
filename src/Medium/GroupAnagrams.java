package Medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 49. Group Anagrams
 * 
 * Given an array of strings strs, group the anagrams together. You can return
 * the answer in any order.
 * 
 * An Anagram is a word or phrase formed by rearranging the letters of a
 * different word or phrase, typically using all the original letters exactly
 * once.
 *
 * Input: strs = ["eat","tea","tan","ate","nat","bat"]
 * 
 * Output: [["bat"],["nat","tan"],["ate","eat","tea"]]
 */
public class GroupAnagrams {
	public static void main(String[] args) {
		String[] strs = { "abbbbbbbbbbbbbb", "aa", "tan", "ate", "nat", "bat" };
		List<List<String>> groupAnagrams = groupAnagrams2(strs);
		System.out.println(groupAnagrams);
	}

	/**
	 * 用map记录每个字符串排序后的样子, faster than 98.93%
	 * 
	 * 新发现:在提交代码的时候要把测试用的输出语句删掉，在这里如果有输出语句, faster than 11.83%
	 * 
	 * @param strs
	 * @return
	 */
	public static List<List<String>> groupAnagrams(String[] strs) {
		List<List<String>> result = new ArrayList<List<String>>();
		Map<String, List<String>> map = new HashMap<String, List<String>>();
		for (int i = 0; i < strs.length; i++) {
			char[] charArray = strs[i].toCharArray();
			Arrays.sort(charArray);
			String str = String.valueOf(charArray);
			if (!map.containsKey(str)) {
				List<String> list = new ArrayList<String>();
				list.add(strs[i]);
				map.put(str, list);
			} else {
				map.get(str).add(strs[i]);
			}
		}

		for (String string : map.keySet()) {
			result.add(map.get(string));
		}
		return result;
	}

	/**
	 * 26个字母的计数法, faster than 98.93%
	 * 
	 * @param strs
	 * @return
	 */
	public static List<List<String>> groupAnagrams2(String[] strs) {
		Map<String, List<String>> map = new HashMap<String, List<String>>();
		for (int i = 0; i < strs.length; i++) {
			// 这里不用int[]的原因是，假如有超过10个该字母可能出错
			// 假设aabbbbbbbbbbbbc 拼接字符串为2121, 而aaaaaaaaaaaaaaaaaaaaabbc也可以和它匹配
			char[] charArray = new char[26];
			for (int j = 0; j < strs[i].length(); j++) {
				charArray[strs[i].charAt(j) - 'a']++;
			}
			String key = String.valueOf(charArray);
			map.putIfAbsent(key, new ArrayList<String>());
			map.get(key).add(strs[i]);
		}
		return new ArrayList<List<String>>(map.values());
	}
}
