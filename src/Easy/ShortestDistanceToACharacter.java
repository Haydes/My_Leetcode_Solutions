package Easy;

import java.util.Arrays;

/**
 * 
 * 821. Shortest Distance to a Character
 * 
 * Given a string s and a character c that occurs in s, return an array of
 * integers answer where answer.length == s.length and answer[i] is the distance
 * from index i to the closest occurrence of character c in s.
 * 
 * The distance between two indices i and j is abs(i - j), where abs is the
 * absolute value function.
 *
 */
public class ShortestDistanceToACharacter {
	public static void main(String[] args) {
		String s = "loveleetcode";
		char c = 'e';
		int[] shortestToChar = shortestToChar(s, c);
		System.out.println(Arrays.toString(shortestToChar));
	}

	/**
	 * 3ms, faster than 31.26%
	 * 
	 * @param s
	 * @param c
	 * @return
	 */
	public static int[] shortestToChar(String s, char c) {
		int[] result = new int[s.length()];
		for (int i = 0; i < result.length; i++) {
			int distance = 0;
			while (i + distance < result.length || i - distance >= 0) {
				if (i + distance < result.length && s.charAt(i + distance) == c) {
					result[i] = distance;
					break;
				}
				if (i - distance >= 0 && s.charAt(i - distance) == c) {
					result[i] = distance;
					break;
				}
				distance++;
			}
		}
		return result;
	}

	/**
	 * 2-pass, 1 ms, faster than 96.84%
	 * 
	 * @param s
	 * @param c
	 * @return
	 */
	public static int[] shortestToChar2(String s, char c) {
		int[] result = new int[s.length()];
		int pos = -s.length();
		for (int i = 0; i < result.length; i++) {
			if (c == s.charAt(i)) {
				pos = i;
			}
			result[i] = i - pos;
		}

		for (int i = pos - 1; i >= 0; i--) {
			if (c == s.charAt(i)) {
				pos = i;
			}
			result[i] = Math.min(result[i], pos - i);
		}
		return result;
	}
}
