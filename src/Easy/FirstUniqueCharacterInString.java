package Easy;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/**
 * 387. First Unique Character in a String
 * 
 * Given a string, find the first non-repeating character in it and return its
 * index. If it doesn't exist, return -1.
 *
 */
public class FirstUniqueCharacterInString {
	public static void main(String[] args) {
		System.out.println(firstUniqChar3("loveleetcode"));
	}

	/**
	 * faster than 62.65%
	 * 
	 * @param s
	 * @return
	 */
	public static int firstUniqChar(String s) {
		int first = Integer.MAX_VALUE;
		// use the map to store the index of each character
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		for (int i = 0; i < s.length(); i++) {
			if (map.containsKey(s.charAt(i))) {
				map.put(s.charAt(i), -1);
			} else {
				map.put(s.charAt(i), i);
			}
		}
		Set<Character> keySet = map.keySet();
		for (Character character : keySet) {
			int value = map.get(character);
			if (value != -1) {
				if (first > value) {
					first = value;
				}
			}
		}
		return first == Integer.MAX_VALUE ? -1 : first;
	}

	/**
	 * faster than 24.73%
	 * 
	 * @param s
	 * @return
	 */
	public static int firstUniqChar2(String s) {
		// use the map to store count
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		for (int i = 0; i < s.length(); i++) {
			if (map.containsKey(s.charAt(i))) {
				map.put(s.charAt(i), map.get(s.charAt(i)) + 1);
			} else {
				map.put(s.charAt(i), 1);
			}
		}

		for (int i = 0; i < s.length(); i++) {
			if (map.get(s.charAt(i)) == 1) {
				return i;
			}
		}

		return -1;
	}

	/**
	 * faster than 100%
	 * 
	 * @param s
	 * @return
	 */
	public static int firstUniqChar3(String s) {
		int result = Integer.MAX_VALUE;
		for (char i = 'a'; i <= 'z'; i++) {
			int index = s.indexOf(i);
			if (index != -1 && index == s.lastIndexOf(i)) {
				result = Math.min(result, index);
			}
		}
		return result == Integer.MAX_VALUE ? -1 : result;
	}
}
