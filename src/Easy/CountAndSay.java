package Easy;

/**
 * 38. Count and Say
 * 
 * The count-and-say sequence is a sequence of digit strings defined by the
 * recursive formula:
 * 
 * countAndSay(1) = "1"
 * 
 * countAndSay(n) is the way you would "say" the digit string from
 * countAndSay(n-1), which is then converted into a different digit string.
 * 
 * To determine how you "say" a digit string, split it into the minimal number
 * of groups so that each group is a contiguous section all of the same
 * character. Then for each group, say the number of characters, then say the
 * character. To convert the saying into a digit string, replace the counts with
 * a number and concatenate every saying.
 *
 */
public class CountAndSay {
	public static void main(String[] args) {
		String countAndSay = countAndSay(6);
		System.out.println(countAndSay);
	}

	/**
	 * faster than 94.91%
	 * 
	 * @param n
	 * @return
	 */
	public static String countAndSay(int n) {
		if (n == 1) {
			return "1";
		}
		String str = countAndSay(n - 1);
		StringBuilder result = new StringBuilder();
		int count = 1;
		char num = str.charAt(0);
		for (int i = 1; i < str.length(); i++) {
			if (str.charAt(i) != num) {
				result.append(count).append(num);
				num = str.charAt(i);
				count = 1;
			} else {
				count++;
			}
		}

		result.append(count).append(num);
		return result.toString();
	}

}
