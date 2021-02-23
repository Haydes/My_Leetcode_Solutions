package Easy;

/**
 * 67. Add Binary
 * 
 * Given two binary strings a and b, return their sum as a binary string.
 *
 */
public class AddBinary {
	public static void main(String[] args) {
		System.out.println(addBinary("11", "1"));
	}

	/**
	 * faster than 100.00%
	 * 
	 * @param a
	 * @param b
	 * @return
	 */
	public static String addBinary(String a, String b) {
		StringBuilder sb = new StringBuilder();
		int i = a.length() - 1;
		int j = b.length() - 1;
		int carry = 0;
		int sum = 0;
		while (i >= 0 || j >= 0) {
			sum = carry;
			if (i >= 0) {
				sum += a.charAt(i) - '0';
				i--;
			}
			if (j >= 0) {
				sum += b.charAt(j) - '0';
				j--;
			}
			sb.append(sum % 2);
			carry = sum / 2;
		}
		if (carry == 1) {
			sb.append(1);
		}
		return sb.reverse().toString();
	}
}
