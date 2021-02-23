package Medium;

/**
 * 43. Multiply Strings
 * 
 * Given two non-negative integers num1 and num2 represented as strings, return
 * the product of num1 and num2, also represented as a string.
 * 
 * Note: You must not use any built-in BigInteger library or convert the inputs
 * to integer directly.
 *
 */
public class MultiplyStrings {
	public static void main(String[] args) {
		String num1 = "234";
		String num2 = "345";
		String multiply = multiply(num1, num2);
		System.out.println(multiply);
	}

	/**
	 * faster than 16.13%
	 * @param num1
	 * @param num2
	 * @return
	 */
	public static String multiply(String num1, String num2) {
		if ("0".equals(num1) || "0".equals(num2)) {
			return "0";
		}
		int carry = 0;
		String multiply = "";
		int[] result = new int[num1.length() + num2.length() - 1];

		for (int i = 0; i < num1.length(); i++) {
			for (int j = 0; j < num2.length(); j++) {
				int x = num1.charAt(i) - '0';
				int y = num2.charAt(j) - '0';
				result[i + j] += x * y;
			}
		}

		for (int i = result.length - 1; i >= 0; i--) {
			result[i] += carry;
			multiply = result[i] % 10 + multiply;
			carry = result[i]/10;
		}
		
		if (carry > 0) {
			multiply = carry + multiply;
		}
		return multiply;
	}
}
