package Hard;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/**
 * 30. Substring with Concatenation of All Words
 * 
 * You are given a string s and an array of strings words of the same length.
 * Return all starting indices of substring(s) in s that is a concatenation of
 * each word in words exactly once, in any order, and without any intervening
 * characters.
 * 
 * You can return the answer in any order.
 * 
 * Constraints:
 * 
 * 1 <= s.length <= 104 s consists of lower-case English letters.
 * 
 * 1 <= words.length <= 5000
 * 
 * 1 <= words[i].length <= 30
 * 
 * words[i] consists of lower-case English letters.
 *
 */
public class SubstrWithConcatenationOfAllWords {
	public static void main(String[] args) {
		String s = "mississippi";
		String[] words = { "si", "is" };
		List<Integer> list = findSubstring(s, words);
		System.out.println(list);
	}

	public static List<Integer> findSubstring(String s, String[] words) {
		HashSet<Integer> result = new HashSet<Integer>();
		// 一个单词的长度
		int perWordLen = words[0].length();
		// 字符串s最低的长度要求
		int minLen = words[0].length() * words.length;
		// 如果字符串s的长度不足以拥有一个涵盖所有单词的子串，则返回空集
		if (s.length() < minLen) {
			return new ArrayList<Integer>();
		}

		// 用一个map装words里每个单词和它的出现次数，这个map用于进行备份
		HashMap<String, Integer> map = new HashMap<String, Integer>();

		// 遍历words数据并装进map
		for (int i = 0; i < words.length; i++) {
			if (map.containsKey(words[i])) {
				map.put(words[i], map.get(words[i]) + 1);
			} else {
				map.put(words[i], 1);
			}
		}

		// 这个map用于进行操作
		HashMap<String, Integer> operationMap = new HashMap<String, Integer>();
		operationMap.putAll(map);

		int begin = 0;
		findStr(s, words, result, perWordLen, map, operationMap, begin);
		// result之前的长度
		int preLen = 0;
		// 防止出现aaaaaa这种问题
		while (begin < perWordLen) {
			begin++;
			operationMap.clear();
			operationMap.putAll(map);
			findStr(s, words, result, perWordLen, map, operationMap, begin);
		}
		return new ArrayList<Integer>(result);
	}

	/**
	 * 以单词为单位进行匹配
	 * 
	 * @param s
	 * @param words
	 * @param result
	 * @param perWordLen
	 * @param map
	 * @param operationMap
	 * @param begin
	 */
	private static void findStr(String s, String[] words, HashSet<Integer> result, int perWordLen,
			HashMap<String, Integer> map, HashMap<String, Integer> operationMap, int begin) {
		// 这个queue记录子串的每个单词索引
		Queue<Integer> queue = new LinkedList<Integer>();
		// 以单词为单位进行判断
		for (int i = begin; i <= s.length() - perWordLen; i += perWordLen) {
			// 这个是当前要判断的单词
			String str = s.substring(i, i + perWordLen);
			// 当前单词在map中
			if (operationMap.containsKey(str)) {
				// 如果当前单词还有剩余
				if (operationMap.get(str) >= 1) {
					// 消耗掉一个
					operationMap.put(str, operationMap.get(str) - 1);
					// 索引放进queue里面
					queue.offer(i);
					// 如果queue中元素跟words中相同，则视为已找到一个子集
					if (queue.size() == words.length) {
						// 把第一个元素从queue中出列
						int index = queue.poll();
						// 结果集中添加该索引
						result.add(index);
						// 由于queue中出列了， map中的相应元素也应该+1
						String keyStr = s.substring(index, index + perWordLen);
						operationMap.put(keyStr, operationMap.get(keyStr) + 1);
					}
				} else {
					while (!queue.isEmpty()) {
						// 当前单词已出现次数超过words中出现次数，无效子串, 找出队列中上一个该单词出现时的索引
						int ii = queue.poll();
						// 这个是在index位置得到的单词
						String subStr = s.substring(ii, ii + perWordLen);
						// 由于queue中出列了， map中的相应元素也应该+1
						operationMap.put(subStr, operationMap.get(subStr) + 1);
						// 这个单词跟当前判断的单词一样
						if (subStr.equalsIgnoreCase(str)) {
							// 当前单词入队
							queue.offer(i);
							// 当前单词入队之后在map中消耗掉一个
							operationMap.put(str, operationMap.get(str) - 1);
							// 如果queue中元素跟words中相同，则视为已找到一个子集
							if (queue.size() == words.length) {
								// 把第一个元素从queue中出列
								int index = queue.poll();
								// 结果集中添加该索引
								result.add(index);
								// 由于queue中出列了， map中的相应元素也应该+1
								String keyStr = s.substring(index, index + perWordLen);
								operationMap.put(keyStr, operationMap.get(keyStr) + 1);
							}
							break;
						}

					}
				}
			} else { // 当前不在map中
				// 直接重置map
				operationMap.clear();
				operationMap.putAll(map);
				// 也重置queue
				queue.clear();
			}
		}
	}

	/**
	 * 改进版
	 * 
	 * faster than 96.30%
	 * 
	 * @param s
	 * @param words
	 * @return
	 */
	public static List<Integer> findSubstring2(String s, String[] words) {
		if (words.length == 0 || s.length() == 0)
			return new ArrayList<Integer>();
		List<Integer> ans = new ArrayList<>();// the collection of results
		Map<String, Integer> map = new HashMap<>();// record how many times every word appear in words
		int len = words[0].length();
		for (int i = 0; i < words.length; i++) {
			if (!map.containsKey(words[i]))
				map.put(words[i], 1);
			else
				map.put(words[i], map.get(words[i]) + 1);
		}
		for (int j = 0; j < len; j++) {// it's like the operation mod,we can add len to i after we do this for()
			int start = j;// the posibble start of the right string
			int count = 0;// record how many words appeared in the string we are using
			Map<String, Integer> currentMap = new HashMap<String, Integer>();// record how many times every word appears
																				// in the string we are using
			for (int i = j; i <= s.length() - len; i += len) {
				String sNow = s.substring(i, i + len);
				if (map.containsKey(sNow)) {
					if (currentMap.containsKey(sNow))
						currentMap.put(sNow, currentMap.get(sNow) + 1);
					else
						currentMap.put(sNow, 1);
					count++;
					if (map.get(sNow) < currentMap.get(sNow)) {
						boolean flag = true;
						while (flag) {
							String sHead = s.substring(start, start + len);
							currentMap.put(sHead, currentMap.get(sHead) - 1);
							count--;
							start = start + len;
							if (sHead.equals(sNow))
								flag = false;
						}
						continue;
					}
					// count++;
					if (count == words.length) {
						ans.add(start);
						String sHead = s.substring(start, start + len);
						currentMap.put(sHead, currentMap.get(sHead) - 1);
						count--;
						start += len;
						continue;
					}
				} else {
					currentMap.clear();
					count = 0;
					start = i + len;
				}

			}
		}
		return ans;
	}
}
